package solution4;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 */
public class CountAndSay {

    public static String countAndSay(int n) {

        StringBuilder cur=new StringBuilder("1");
        StringBuilder prev=cur;
        //当前字符出现的次数
        int count=1;
        //记录当前字符，循环判断say出现了几次
        char say;
        //从1开始，因为n是1就直接出循环了，直接返回1
        for (int i=1;i<n;i++){
            prev=cur;
            //重置cur
            cur=new StringBuilder();
            //重置count
            count=1;
            //因为下一个字符串是由前一个字符串决定的
            say=prev.charAt(0);
            for(int j=1;j<prev.length();j++){
                if(say!=prev.charAt(j)){
                    cur.append(count).append(say);
                    //当前字符与下一个字符不同时，此时需要重置count
                    count=1;
                    //每当数字不一样了，就修改say
                    say=prev.charAt(j);
                }else{
                    count++;
                }
            }
            //输出几个一，最后一个数字必然是1
            cur.append(count).append(say);
            System.out.println(cur.toString());
        }
        return cur.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
