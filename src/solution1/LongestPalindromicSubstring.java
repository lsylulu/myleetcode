package solution1;

import java.util.Stack;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class LongestPalindromicSubstring {

    /**
     * 每次遍历都返回当前下标的字符或它右边空隙为中心的最长回文子串
     * 时间复杂度为O(n^2)
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if(s==null||s.length()==0){
            return "";
        }
        //初始化，默认最长回文子串是第一个字母
        String result=s.substring(0,1);
        String help="";
        //每次遍历，寻找以当前字符为中心或右边空隙的最长回文子串
        for(int i=0;i<s.length();i++){
            //回文串中间有字符的情况
            help=getCurrentLongest(i,i,s);

            if(help.length()>result.length()){
                result=help;
            }

            //回文串中间无字符的情况
            help=getCurrentLongest(i+1,i,s);
            if(help.length()>result.length()){
                result=help;
            }

        }
        return result;
    }

    /**
     * 刚开始在中间，start往右走，end往左走
     * 返回当前string的最长回文子串
     * @param start
     * @param end
     * @param s
     * @return
     */
    private static String getCurrentLongest(int start ,int end,String s) {
        while(start<s.length()&&end>=0&&s.charAt(start)==s.charAt(end)){
            start++;
            end--;
        }
        //此时end必然比正确的区间小1，start比正确的区间大1，subString又是左闭右开的
        s=s.substring(end+1,start);
        return s;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));

    }
}
