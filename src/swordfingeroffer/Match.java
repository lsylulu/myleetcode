package swordfingeroffer;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Match {

    public static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return match(str, 0, pattern, 0);
    }

    /**
     * @param str
     * @param i       当前匹配成功的str长度
     * @param pattern
     * @param j
     * @return
     */
    private static boolean match(char[] str, int i, char[] pattern, int j) {
        if (pattern.length == j) {
            return str.length == i;
        }
        //处理'*'
        if (j < pattern.length - 1 && pattern[j + 1] == '*') {
            if (str.length != i && (str[i] == pattern[j] || pattern[j] == '.')) {
                //跳过pattern||跳过str
                return match(str, i, pattern, j + 2) || match(str, i + 1, pattern, j);
            } else {
                //当前不匹配，跳过pattern，让前面的字符出现0次
                return match(str, i, pattern, j + 2);
            }
        }
        //下一个不是'*'
        if (str.length != i && (str[i] == pattern[j] || pattern[j] == '.')) {
            return match(str, i + 1, pattern, j + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        boolean res=match("aaa".toCharArray(),"ab*ac*a".toCharArray());
        System.out.println(res);
    }
}
