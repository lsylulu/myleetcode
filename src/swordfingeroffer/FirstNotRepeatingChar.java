package swordfingeroffer;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）
 */
public class FirstNotRepeatingChar {

    public static int FirstNotRepeatingChar(String str) {
        int[] words = new int[58];
        for (int i = 0; i < str.length(); i++) {
            words[((int) str.charAt(i)) - 65] += 1;
        }
        //并不是对数组简单的遍历，而是按照str的顺序进行查找
        //所以必然是第一次出现不重复的字符
        for (int i = 0; i < str.length(); i++) {
            if (words[((int) str.charAt(i)) - 65] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int i=FirstNotRepeatingChar("cbaa");
        System.out.println(i);
    }
}
