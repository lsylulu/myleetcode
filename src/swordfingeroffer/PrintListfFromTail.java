package swordfingeroffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class PrintListfFromTail {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        Stack<Integer> help=new Stack();
        ListNode cur=listNode;
        ArrayList<Integer> res=new ArrayList<>();
        while (cur!=null){
            help.push(cur.val);
            cur=cur.next;
        }
        while (!help.isEmpty()){
            res.add(help.pop());
        }
        return res;
    }
}
