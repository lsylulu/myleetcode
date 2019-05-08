package solution3;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapNodesInPairs {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 先从前到后遍历，再从后到前交换
     * 1.找终止条件：本题终止条件很明显，
     * 当递归到链表为空或者链表只剩一个元素的时候，没得交换了，自然就终止了。
     * 2.找返回值：返回给上一层递归的值应该是已经交换完成后的子链表。
     * 3.单次的过程：因为递归是重复做一样的事情，所以从宏观上考虑，
     * 只用考虑某一步是怎么完成的。我们假设待交换的俩节点分别为head和next，
     * next的应该接受上一级返回的子链表(参考第2步)。就相当于是一个含三个节点的链表交换前两个节点
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode next=head.next;
        head.next=swapPairs(next.next);
        next.next=head;
        return next;
    }
}
