package swordfingeroffer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Add {

    public int Add(int num1, int num2) {
        //当进位为0000时则停止
        while (num2 != 0) {
            //相加
            int temp = num1 ^ num2;
            //进位
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }
}
