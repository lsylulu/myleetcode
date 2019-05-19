package solution5;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 *
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 *
 */
public class WildcardMatching {

    /**
     * 动态规划法
     * @param text
     * @param pattern
     * @return
     */
    public boolean isMatch(String text, String pattern) {

        //最后一个存放最终结果
        boolean[][] m = new boolean[text.length()+1][pattern.length()+1];

        //两个字符串都为空是肯定匹配
        m[0][0] = true;
        for(int i = 0; i <= text.length(); i++) {
            for(int j = 1; j <= pattern.length(); j++) {
                if(pattern.charAt(j-1) == '*') {
                    //其实就是两种情况，
                    //1）m[i][j-1] 即当前'*'匹配一个空字符
                    //2）m[i-1][j] 即当前'*'匹配一个字符s.charAt(i-1)
                    //这里之所以不是m[i-1][j-1]是因为当前'*'可能在前面一匹配了若干个字符
                    m[i][j] = m[i][j-1] || (i > 0 && m[i-1][j]);
                } else {
                    //之前的情况必须匹配，并且当前字符相同时才能是true
                    m[i][j] = i > 0 && m[i-1][j-1] && (text.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?');
                }
            }
        }

        return m[text.length()][pattern.length()];
    }
}
