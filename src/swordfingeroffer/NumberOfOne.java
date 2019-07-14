package swordfingeroffer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOfOne {

    /**
     * 利用左移操作
     *
     * @param n
     * @return
     */
    public int NumberOf1(int n) {

        int count = 0;
        //flag是当前位，每次都左移，根据&的结果比较对应位是否位1
        int flag = 1;
        while (flag != 0) {
            if ((flag & n) != 0) {
                count++;
            }
            flag <<= 1;
        }
        return count;
    }
}
