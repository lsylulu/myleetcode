package solution2;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 */
public class LetterCombinationsPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        //将索引与数字对应起来
        String[] alphabet = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList();
        //第一次遍历的时候就能将所有字符都插进来
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            List<String> help = new ArrayList();
            // 通过ASCII的差
            // 拿出数字对应的字符串
            String str = alphabet[digits.charAt(i) - '0'];
            for (int j = 0; j < str.length(); j++) {
                for(int k=0;k<res.size();k++){
                    //顺序不可调换，不然不通过
                    //把alphabet中对应的每一个字符，一一拼接到结果中
                    //每一次的help都是在上一次的res基础上进行拼接
                    //使用help能把之前的res元素给过滤，因为如果进来的是2个数
                    //只用res的话一定有一个字母的元素，这种情况是不对的
                    //而且res.size()会一直增加，导致死循环
                    help.add( res.get(k)+str.charAt(j));
                }
            }
            res = help;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("239"));
    }
}
