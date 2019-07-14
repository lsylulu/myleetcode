package swordfingeroffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class AbnormalJumpFloor {

    /**
     * n=1，ans=1
     * n=2，ans=2
     * n=3,  ans=4(前面的和+直接到该台阶的方法)
     * n=4,  ans=8
     * n=5, ans=16
     * n=n, ans=2^(n-1)
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        return 1<<(target-1);
    }
}
