package swordfingeroffer;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {

    /**
     * num1,num2分别为长度为1的数组。传出参数
     * 将num1[0],num2[0]设置为返回结果
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        HashSet help=new HashSet();
        for(int i=0;i<array.length;i++){
            if(help.contains(array[i])){
                help.remove(array[i]);
            }else{
                help.add(array[i]);
            }
        }
        Iterator iterator=help.iterator();
        num1[0]=(int)iterator.next();
        num2[0]=(int)iterator.next();
    }
}
