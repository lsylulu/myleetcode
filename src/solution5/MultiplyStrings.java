package solution5;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class MultiplyStrings {

    /**
     * 就是记录每一个进位的情况，下一次运算后再加上
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {

        char[] a = num1.toCharArray();
        char[] b = num2.toCharArray();
        int[] res = new int[a.length + b.length];
        if (a.length < 0 || b.length < 0) {
            return "";
        }
        //从最后开始遍历两个数组
        for (int i = a.length-1; i >= 0; i--) {
            for (int j = b.length-1; j >= 0; j--) {
                int mul = (a[i] - '0') * (b[j] - '0');
                mul += res[i + j + 1];
                //当前数等于上一个的进位数+相乘后的值
                //然后把当前位相乘后的进位数赋值给下一位
                res[i + j] += mul / 10;
                res[i + j + 1] = mul % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        //去掉res开头的所有0，剩下的就是结果
        int i = 0;
        while (i < res.length - 1 && res[i] == 0) {
            i++;
        }
//        for (int re : res) {
//            System.out.print(re+" ");
//        }
        for (; i < res.length; i++) {
            sb.append(res[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String res=multiply("123","500");
        System.out.println(res);
    }
}
