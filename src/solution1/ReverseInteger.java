package solution1;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 */
public class ReverseInteger {

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            //判断必须放在循环刚开始，否则溢出后，判断失效
            if(Math.abs(res)>Integer.MAX_VALUE/10){
                return 0;
            }
                int singleNum = x % 10;
                x /= 10;
                //将之前的数*10+取出的当前数的个位数
                res = res * 10 + singleNum;
            System.out.println();
        }
        return res;
    }
}
