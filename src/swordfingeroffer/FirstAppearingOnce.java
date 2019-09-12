package swordfingeroffer;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class FirstAppearingOnce {

    public String s="";
    public char[] hash=new char[256];

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        s+=ch;
        hash[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(int i=0;i<s.length();i++){
            if(hash[s.charAt(i)]==1){
                return s.charAt(i);
            }
        }
        return '#';
    }
}
