package solution2;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: "III"
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: "IV"
 * 输出: 4
 *
 * 示例 3:
 *
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class RomanToInteger {

    /**
     * 观察发现，
     * V 和X 左边的小数字只能用Ⅰ。
     * L 和C 左边的小数字只能用X。
     * D 和M 左边的小数字只能用C。
     * V-I=4
     * X-I=9
     * L-X=40
     * C-C=90
     * D-C=400
     * M-C=900
     * @param s
     * @return
     */
    public int RomanToInt(String s) {
        int res = 0;
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        for (int i = 0; i < s.length(); i++) {
            int val = m.get(s.charAt(i));
            //如果当前取出的这个数是最后一个数字
            //或者这个数大于他后一个数，则按正常顺序走
            if (i == s.length() - 1 || m.get(s.charAt(i + 1)) <= m.get(s.charAt(i))) {
                res += val;
            } else {
                //减去这个数再加上下一个数，刚好就是这两个字母表示的数
                res -= val;
            }
        }
        return res;
    }

}
