package swordfingeroffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {

    public String PrintMinNumber(int [] numbers) {

            int n;
            String res="";
            ArrayList<Integer> help= new ArrayList<Integer>();
            n=numbers.length;
            for(int i=0;i<n;i++){
                help.add(numbers[i]);

            }
            Collections.sort(help, new Comparator<Integer>(){

                @Override
                public int compare(Integer str1,Integer str2){
                    String s1=str1+""+str2;
                    String s2=str2+""+str1;
                    return s1.compareTo(s2);
                }
            });

            for(int num:help){
                res+=num;
            }
            return res;
    }
}
