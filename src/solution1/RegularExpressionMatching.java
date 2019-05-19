package solution1;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
 * 示例 3:
 * <p>
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
     *
     * @param text
     * @param pattern
     * @return
     */
    public boolean isMatch(String text, String pattern) {

        //1.找到递归的caseBase，结束条件
        //如果text与pattern都为空，则匹配成功
        //如果一个匹配完了，另一个还没完事，则匹配失败
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        //判断text与pattern的第一个字符是否能匹配上
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        //3.本次递归需要做什么
        //当pattern的下一个字符为*时
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            //4.本次递归需要下一次递归返回什么
            //发挥*的第一个作用，将自己前面不匹配的都删去，因为*可以让之前的元素
            //都出现0次
            return (isMatch(text, pattern.substring(2)) ||
                    //尝试着匹配了一个前面的元素，保留'*'，看看后面的需不需要
                    //发挥'*'的第二个作用，即能匹配多个前面出现的元素
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            //没有'*'的情况，并且第一个字符匹配，一个一个比，看看后面的字符是否也匹配
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    /**
     * 方法二，自底向上动态规划
     * 是通过暴力递归改出来的
     *
     * 动态规划分两种形式：一种是自顶向下的，采用递归；
     * 另一种是自底向上的，从求解最小的子问题开始，逐步求解得原问题，就是递推法。
     *
     * @param text
     * @param pattern
     * @return
     */
    public boolean isMatch2(String text, String pattern) {

        //多出来的那个位置设为true，放最后
        boolean[][] memo = new boolean[text.length() + 1][pattern.length() + 1];
        memo[text.length()][pattern.length()] = true;
        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                //字符相等或出现'.'就表示当前元素能够匹配
                boolean curMatch = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                //当下一个字符为'*'时
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    memo[i][j] = memo[i][j + 2] || curMatch && memo[i + 1][j];
                } else {
                    memo[i][j] = curMatch && memo[i + 1][j + 1];
                }
            }
        }
        return memo[0][0];
    }


}
