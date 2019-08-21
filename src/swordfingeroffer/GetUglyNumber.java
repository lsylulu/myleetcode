package swordfingeroffer;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber {

    public int GetUglyNumber_Solution(int index) {
        if (index < 7) return index;
        int[] res = new int[index];
        res[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for (int i = 1; i < index; i++) {
            //当前的丑数就是之前所有的丑数中乘以2或3或5得到的
            res[i] = Math.min(Math.min(res[t2] * 2, res[t3] * 3), res[t5] * 5);
            if (res[i] == res[t2] * 2) t2++;
            if (res[i] == res[t3] * 3) t3++;
            if (res[i] == res[t5] * 5) t5++;
        }
        return res[index - 1];
    }
}
