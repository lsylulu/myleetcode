package swordfingeroffer;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class Multiply {

    public int[] multiply(int[] A) {

        if (A == null || A.length == 0) {
            return A;
        }
        int[] before = new int[A.length];
        int[] after = new int[A.length];
        int[] res = new int[A.length];
        before[0] = 1;
        after[A.length - 1] = 1;
        for (int i = 1; i < A.length; i++) {
            before[i] = before[i - 1] * A[i - 1];
        }
        for (int i = A.length - 2; i >= 0; i--) {
            after[i] = after[i + 1] * A[i + 1];
        }
        for (int i = 0; i < A.length; i++) {
            res[i] = before[i] * after[i];
        }
        return res;
    }
}
