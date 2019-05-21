package solution5;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class PowxN {

    /**
     * 使用折半的思路，i是每次尝试的幂，i为0时，整个过程就结束了
     * 当i为奇数，则与自己相乘，i为偶数，则于res相乘
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        double res = 1.0;

        for(int i = n; i != 0; i /= 2){
            if(i % 2 != 0){
                res*= x;
            }
            x *= x;
        }
        return  n < 0 ? 1 / res : res;
    }
}
