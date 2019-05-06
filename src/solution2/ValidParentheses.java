package solution2;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class ValidParentheses {

    public static boolean isValid(String s) {

        Stack<Character> help=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                help.push(s.charAt(i));
            }else{
                if(help.isEmpty()){
                    return false;
                }
                if(s.charAt(i)==')'){
                    if(help.pop()!='('){
                        return false;
                    }
                }
                if(s.charAt(i)==']'){
                    if(help.pop()!='['){
                        return false;
                    }
                }
                if(s.charAt(i)=='}'){
                    if(help.pop()!='{'){
                        return false;
                    }
                }
            }

        }
        //最终匹配完，栈必然为空
        return help.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
