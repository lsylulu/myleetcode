package solution3;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 利用小顶堆的数据结构，每次都取最上面的元素
     * 并将最上面节点的后继节点入队
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> help=new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        //将每个链表的头节点都放到堆中
        for (ListNode node:lists){
            if(node!=null){
            help.offer(node);
            }
        }
        //头节点
        ListNode head=new ListNode(-1);
        ListNode cur=head;
        while (!help.isEmpty()){
            ListNode temp=help.poll();
            //不能直接cur.next=temp
            //因为temp的next属性也会带过去，造成错乱
            cur.next=new ListNode(temp.val);
            if(temp.next!=null) {
                help.offer(temp.next);
            }
            cur=cur.next;
        }

        return head.next;
    }
}
