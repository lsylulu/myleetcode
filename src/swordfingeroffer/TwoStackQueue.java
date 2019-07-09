package swordfingeroffer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class TwoStackQueue {

    //入栈的元素必须进这里
    Stack<Integer> pushStack = new Stack<Integer>();
    //出栈的元素必须从这里出
    Stack<Integer> popStack = new Stack<Integer>();

    public void push(int node) {
        dao();
        pushStack.push(node);
    }

    public int pop() {

        //取数据时，先判空
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException("queue is empty!");
        }
        dao();
        return popStack.pop();
    }

    /**
     * pushStack中的数据要往popStack中倒，取元素的时候需要从popStack中取
     * popStack中有元素时，不可以倒入。一次倒入必须倒完。
     */
    public void dao() {
        if (!popStack.isEmpty()) {
            return;
        }
        while (!pushStack.isEmpty()) {
            popStack.add(pushStack.pop());
        }
    }
}
