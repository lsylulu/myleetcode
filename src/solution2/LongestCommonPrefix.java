package solution2;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {

    /**
     * 方法1，水平扫描
     * 默认第一个是prefix，与每一个strs进行比较，当公共前缀
     * 与某个字符串一个也对不上时，则返回""
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) {return "";}
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {return "";}
            }
        }
        return prefix;
    }

    /**
     * 方法2，纵向扫描
     * 总体时间负杂度与方法1一样，但常数项会小一点
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if(strs==null||strs.length==0){
            return  "";
        }
        String prefix="";
        //采用纵向遍历的方式
        for(int j=0;j<strs[0].length();j++){
            char c=strs[0].charAt(j);
            for(int i=1;i<strs.length;i++){
                //竖着切时，有一个不一样或某个字符串遍历完了，则表示公共前缀已经找到
                //当strs数量很多时，这种方法效果最佳
                if(j>=strs[i].length()||strs[i].charAt(j)!=c){
                    return  prefix;
                }
            }
            prefix+=Character.toString(c);
        }
        return  prefix;
    }


    public static void main(String[] args) {
        String[] str = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix2(str));
    }
}
