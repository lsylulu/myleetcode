package swordfingeroffer;

/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class StrToInt {

    public int StrToInt(String str) {

        if(str==null||str.length()==0){
            return 0;
        }
        char mark=0;
        if('-'==str.charAt(0)){
            mark=1;
        }
        int sum=0;
        char[] ch=str.toCharArray();
        for(int i=0;i<str.length();i++){
            if(ch[i]=='+'||ch[i]=='-'){
                continue;
            }
            if(ch[i]<48||ch[i]>57){
                return 0;
            }
            sum=sum*10+ch[i]-48;
        }
        return mark==0?sum:sum*-1;
    }
}
