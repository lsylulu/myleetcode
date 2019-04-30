package solution1;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x==0){
            return  true;
        }
        //负数必然不可能是回文数
        if(x<0){
            return  false;
        }
        //代表x最终逆置后的数
        int res=0;
        //每次循环除去个位的数
        int tmp=x;
        while(tmp!=0){
            res=res*10+tmp%10;
            tmp=tmp/10;
        }
        return  res==x;
    }

}
