package swordfingeroffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {

    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer,Integer> times=new HashMap<>();
        for(int i=0;i< array.length;i++){
            if(times.containsKey(Integer.valueOf(array[i]))){
                int count=times.get(Integer.valueOf(array[i]));
                times.put(Integer.valueOf(array[i]),count+1);
            }else {
                times.put(Integer.valueOf(array[i]),1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : times.entrySet()) {
            if(entry.getValue()>array.length/2){
                return entry.getKey();
            }
        }
        return 0;
    }
}
