package swordfingeroffer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Fibonacci {

    /**
     * 方法一
     * 递归，但是对于比较大的n会存在stackOverflow的问题
     * @param n
     * @return
     */
    public int Fibonacci1(int n) {
        if(n<1){
            return n;
        }
        return Fibonacci1(n-1)+Fibonacci1(n-2);
    }

    /**
     * 方法二
     * 以一定的空间代价，避免重复计算的栈空间浪费
     */
    public static int[] res=null;
    public int Fibonacci(int n) {

        if(n<1){
            return n;
        }
        res=new int[n+1];
        res[0]=0;
        res[1]=1;
        for(int i=2;i<=n;i++){
            res[i]=res[i-1]+res[i-2];
        }
        return res[n];
    }


}
