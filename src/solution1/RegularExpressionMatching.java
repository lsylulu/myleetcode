package solution1;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *
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
 * p = "a*"
 * 输出: true
 * 解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
 */
public class RegularExpressionMatching {

    /**
     * 方法一，暴力递归
     * s是源字符串，p是正则书写的字符串
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        //此时p被截完了，所有的都匹配，返回true
        if(p.isEmpty()){
            return  s.isEmpty();
        }
        //当p的下一个字符为*时，p直接跳到下一个字符，因为*可以匹配0或多个前面的字符
        if(p.length()>1&&p.charAt(1)=='*') {
                   //发挥*的作用，将自己前面不匹配的都删去，因为*可以让之前的元素
                   //都出现0次
            return isMatch(s, p.substring(2)) || (!s.isEmpty()
                    //如果截取到'.'可以匹配任意字符
                    && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                    //此时p是.*开头的，不管s的0索引的元素是什么，直接交给下个match，
                    && isMatch(s.substring(1), p));
        }else {
            return (!s.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.')&&
                    isMatch(s.substring(1),p.substring(1)));
        }
    }

    /**
     * 方法二，自底向上动态规划
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        boolean[][] memo = new boolean[s.length() + 1][p.length() + 1];
        memo[s.length()][p.length()] = true;
        for (int i = s.length(); i >= 0; i--){
            for (int j = p.length() - 1; j >= 0; j--){
                //字符相等或出现'.'就表示当前元素能够匹配
                boolean curMatch = (i < s.length() &&
                        (p.charAt(j) == s.charAt(i) ||
                                p.charAt(j) == '.'));
                //当下一个字符为'*'时
                if (j + 1 < p.length() && p.charAt(j+1) == '*'){
                    memo[i][j] = memo[i][j+2] || curMatch && memo[i+1][j];
                } else {
                    memo[i][j] = curMatch && memo[i+1][j+1];
                }
            }
        }
        return memo[0][0];
    }


}
