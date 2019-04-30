package solution1;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 将排列次序转换成在源字符串的索引规律就是
 * 0   4   8    12
 * 1 3 5 7 9 10 11 13
 * 2   6   10   14
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 */
public class ZigzagConversion {

    /**
     * 这是一道规律题
     * 结合源字符串与输出的排列，
     * 如果是普通元素，相邻的字母相差(2*numRows−2)个位置
     * 如果是中间元素（为了之字形填充的），能确定字符的索引是[2*numRows−2-2*i+j]
     * i是当前行数，j是当前列数
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {

        if (numRows == 1) {return s;}

        StringBuilder res = new StringBuilder();
        int size = 2 * numRows - 2;

        //遍历行
        for (int i = 0; i < numRows; i++) {
            //控制列，每行的首个元素索引等于行数
            for (int j = i; j<s.length(); j += size) {
                res.append(s.charAt(j));
                //当不是首行和尾行时并且是位于中间的特殊元素时
                //tmp是在源字符串中的索引位置
                int tmp=j+2*numRows-2-2*i;
                if (i != 0 && i < numRows - 1 && tmp < s.length()){
                    res.append(s.charAt(tmp));
                }
            }
        }
        return res.toString();
    }

}
