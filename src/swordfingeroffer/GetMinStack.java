package swordfingeroffer;

import java.util.Stack;

/**
 * 定义栈的数据结构，
 * 请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class GetMinStack {

    /**
     * 放当前的最小值
     */
    public static Stack<Integer> help=new Stack<>();
    public static Stack<Integer> data=new Stack<>();

    public static void push(int node) {

        if (help.isEmpty()) {
            help.push(node);
        } else if (node < min()) {
            help.push(node);
        } else {
            help.push(help.peek());
        }
        data.push(node);
    }

    public static void pop() {

        if(data.isEmpty()){
            throw new RuntimeException("栈为空");
        }
        data.pop();
        help.pop();
    }

    public static int top() {

        if (data.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        return data.peek();
    }

    public static int min() {

        if(help.isEmpty()){
            throw new RuntimeException("栈为空");
        }
        return help.peek();
    }
}
