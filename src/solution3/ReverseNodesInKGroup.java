package solution3;

/**
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class ReverseNodesInKGroup {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 把链表分成若干块再交换
     * reverseKGroup用于拆分
     * pre指针是每一段的前一个节点，cur是每一段的最后一个节点，next是下一段的第一个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res=new ListNode(-1);
        res.next=head;
        ListNode cur=head;
        ListNode pre=res;
        for(int i=1;cur!=null;i++){
            if(i%k==0){
                pre=reverseOneGroup(pre,cur.next);
                cur=pre.next;
            }else {
                cur=cur.next;
            }
        }

        return res.next;
    }

    /**
     * 用于交换链表，返回有序那一块的最后一个节点
     * @param pre
     * @param next
     * @return
     */
    ListNode reverseOneGroup(ListNode pre,ListNode next){

        ListNode last=pre.next,cur=last.next;
        //每次都让pre的后一个指向cur，其他的都往后挪
        //最终就会逆序
        while(cur!=next){
            last.next=cur.next;
            cur.next=pre.next;
            pre.next=cur;
            cur=last.next;
        }
        return  last;
    }
}
