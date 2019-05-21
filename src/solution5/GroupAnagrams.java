package solution5;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> help=new HashMap<>();
        List<List<String>> res=new ArrayList<>();
        if(strs.length<1){
            return res;
        }

        for(int i=0;i<strs.length;i++){
            char[] ch=strs[i].toCharArray();
            Arrays.sort(ch);
            //将每一个字符数组排完序后放入map,
            //碰到一样的就加入到对应的list中
            if(help.containsKey(new String(ch))){
                List<String> list=help.get(new String(ch));
                list.add(strs[i]);
                help.put(new String(ch),list);
            }else{
                List<String> list=new ArrayList<>();
                list.add(strs[i]);
                help.put(new String(ch),list);
            }
        }

        for (Map.Entry<String, List<String>> entry : help.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }
}
