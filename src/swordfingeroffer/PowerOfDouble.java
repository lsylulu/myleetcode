package swordfingeroffer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
 */
public class PowerOfDouble {

    /**
     * 方法一
     * 这样肯定拿不到offer
     * @param base
     * @param exponent
     * @return
     */
    public double PowerOne(double base, int exponent) {
        return Math.pow(base,exponent);
    }

    /**
     * 方法二
     * 10^1101 = 10^0001*10^0100*10^1000
     * @param base
     * @param exponent
     * @return
     */
    public double PowerTwo(double base, int exponent) {

        //真实的次数，后续拿这个去做运算
        int n;
        //代表在当前位下的底数，初始为base
        double cur=base;
        //结果
        double res=1;
        //根据次数来分类讨论
        if(exponent>0){
            n=exponent;
        }else if(exponent<0){
            if(base==0){
                throw new RuntimeException("分母不能为0");
            }
            n=-exponent;
        }else{
            //0的0次方，我也不知道为啥是1
            return 1;
        }
        //10^1101 = 10^0001*10^0100*10^1000。
        //通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
        while (n!=0){
            //当前位是1，说明应该乘上去
            if((n&1)==1){
                res*=cur;
            }
            //当前位所表示的数值
            cur*=cur;
            n>>=1;
        }
        //n小于0则是多少分之一
        return exponent>=0?res:(1/res);
    }
}
