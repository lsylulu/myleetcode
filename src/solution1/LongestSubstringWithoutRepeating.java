package solution1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LongestSubstringWithoutRepeating {

    /**
     * 方法一，暴力法
     * 记录开始索引start和结束索引end，
     * start：0~s.length-1
     * end：n+1~s.length-1
     * 每次都判断这个区间内的元素有无重复，有则返回false，没有则返回true并记录
     * end-start作为长度
     * 时间复杂度是O(n^3)
     * 额外空间复杂度是O(n)
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (allUnique(s, i, j)) {
                    res = Math.max(res, j - i);
                }
            }
        }
        return res;
    }

    /**
     * 判断start~end区间内是否有元素重复
     * 利用Set的数据结构，每次遍历都把字符存入Set
     *
     * @param s
     * @param start
     * @param end
     * @return
     */
    public static boolean allUnique(String s, int start, int end) {
        Set<Character> help = new HashSet<>();
        boolean res = true;
        for (int i = start; i <= end; i++) {
            Character ch = s.charAt(i);
            //与之前的字符重复，直接返回false
            if (help.contains(ch)) {
                return false;
            }
            //没有重复的就存入Set
            help.add(ch);
        }
        return res;
    }

    /**
     * 方法二，滑动窗口
     * 时间复杂度为O(n^2)
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        //每一次while结束，i~j之间的当前最长不重复子串的长度
        //就会产生
        //保证i和j时间不可能会有重复的字符
        while (i < n && j < n) {
            // 当j对应的字符重复时，会一直等i前进
            //直到把重复字符去掉为止
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }


    /**
     * 方法三，是方法二的优化版本
     * 方法二中当重复字符出现时，j必须等i走到第一个重复字符的位置并删除
     * 这里如果记录每个字符的位置，就可以减少不必要的等待
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length(), res = 0;
        //记录当前字符的下标，便于直接定位
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                //下必然往前走，不可能走到之前的位置
                i = Math.max(map.get(s.charAt(j)), i);
            }

            System.out.println(map.size());
            res = Math.max(res, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return res;
    }


    public static void main(String[] args) {
        int i = lengthOfLongestSubstring3("abdaacbdef");
        System.out.println(i);
    }
}
