package solution1;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 */
public class StringToIntegerAtoi {

    public int myAtoi(String str) {
        if (str.isEmpty()) {return 0;}
        //signal表示正负，base表示除符号为以外的数字，i是字符串索引的位置
        int signal = 0, base = 0, i = 0, n = str.length();
        while (i < n && str.charAt(i) == ' ') {i++;}
        //判断正负
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            signal = str.charAt(i) == '+' ? 1 : -1;
        }
        //只处理数字的情况
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            //int的最大值是2147483647，所以某位大于7时，返回最大值
            if (base > Integer.MIN_VALUE || (base == Integer.MAX_VALUE && (str.charAt(i) - '0') > 7)) {
                return (signal == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            //s.chatAt(i)-'0'就是当前字符所表示的数字
            base = base * 10 + str.charAt(i++) - '0';
        }
        return signal * base;
    }

}
