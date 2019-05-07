package solution3;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        help(n,n,"",res);
        return res;
    }

    /**
     * 根据剩余的左括号数与右括号数来递归生成答案
     * @param left
     * @param right
     */
    public void help(int left,int right,String res,List<String> list){

        //在拼凑过程中，左括号数驶中大于等于又括号数
        //所以剩余的左括号数必须小于剩余的右括号数
        if(left<0||right<0||left>right){
            return;
        }
        //结束条件，当left与right都为0时，括号匹配成功
        //记录正确答案
        if(left==0&&right==0){
            list.add(res);
            return;
        }
        help(left-1,right,res+"(",list);
        help(left,right-1,res+")",list);
    }
}
