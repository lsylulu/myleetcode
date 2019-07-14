package swordfingeroffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {

    public static void reOrderArray(int [] arr) {

        List<Integer> odd=new ArrayList();
        List<Integer> even=new ArrayList();

        for(int i=0;i<arr.length;i++){
            if((arr[i]&1)==1){
                odd.add(arr[i]);
            }else{
                even.add(arr[i]);
            }
        }
        for(int j=0;j<odd.size();j++){
            arr[j]=odd.get(j);
        }
        for(int k=0;k<even.size();k++){
            arr[k+odd.size()]=even.get(k);
        }
    }

    public static void main(String[] args) {
        int[] arr={1,34,22,3,77,64};
        reOrderArray(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
