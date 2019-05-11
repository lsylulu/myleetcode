package solution3;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。
 * 本题中，如果除法结果溢出，则返回 2^31 − 1。
 */
public class DivideTwoIntegers {

    /**
     * @param dividend 被除数
     * @param divisor  除数
     * @return
     */
    public int divide(int dividend, int divisor) {
        if(dividend==0){
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        //判断两数符号位是否不同
        boolean isNegative=(dividend^divisor)<0;
//        if((dividend^divisor)>0){
//            isNegative=false;
//        }
        //将两数转换为正数处理,不转换为long可能溢出
        long a=Math.abs((long)dividend);
        long b=Math.abs((long)divisor);
        int res=0;
        for(int i=31;i>=0;i--){
            //刚开始，a>>31,数特别小，肯定小于b
            //随着i的增加，总会有a>>i大于b的时候
            //此时相当于a>=b*2^i,也就是真实的商必然大于等于b*2^i
            //把a减去这么多，接着处理，直到最后那个数小于除数，就有答案了
            if((a>>i)>=b){
                //被除数/除数=商+余数
                //现在要的是商，商×除数+余数=被除数
                res=res+(1<<i);
                a=a-(b<<i);
            }

        }
        return isNegative ? -res : res;
    }
}
