package swordfingeroffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Permutation {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res=new ArrayList<>();
        if(str!=null||str.length()>0){
            permutationHelp(str.toCharArray(),0,res);
        }
        Collections.sort(res);
        return res;
    }

    /**
     * 以当前的i为基准点，ch[i]之前的字符串都不变
     * @param ch
     * @param i
     * @param list
     */
    private void permutationHelp(char[] ch, int i, ArrayList<String> list) {
        if(i==ch.length-1){
            String val=String.valueOf(ch);
            if(!list.contains(val)){
                list.add(val);
            }
            return;
        }else{
            for(int j=i;j<ch.length;j++){
                swap(ch,i,j);
                permutationHelp(ch,i+1,list);
                //交换回来，保持数组的顺序，不然会少情况
                swap(ch,i,j);
            }
        }
    }

    public void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
