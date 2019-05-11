package solution3;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。
 * 找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 */
public class SubstringWithAllWords {

    public List<Integer> findSubstring(String s, String[] words) {

        List res=new ArrayList();
        if (words.length == 0 || s.length() == 0) {
            return res;
        }
        int singleLength=words[0].length();

        //strLength-wordsLength*words[0].length()实际上就是个加速的过程
        for(int i=0;i<=s.length()-words.length*singleLength;i++){
            //存放words数组，拿来匹配s
            List help=new ArrayList();
            String sub=s.substring(i,i+singleLength*words.length);
            for(int j=0;j<words.length;j++){
                help.add(sub.substring(j*singleLength,(j+1)*singleLength));
            }
            //每匹配上一个就删除，巧妙的避开了排列组合的问题
            for (int k=0;k<words.length;k++){
                if(help.contains(words[k])){
                    help.remove(words[k]);
                }else {
                    break;
                }
            }

            if(help.isEmpty()){
                res.add(i);
            }
        }
        return res;
    }

}
