package swordfingeroffer;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryNodeOfLoop {


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 设置快慢指针，快指针一次走两步，当快慢指针到一起时则停止
     * 然后快指针返回到头节点，与满指针相同的速度走，必然在环的入口节点相遇
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }
        //设置快指针和慢指针
        ListNode fast=pHead.next.next;
        ListNode slow=pHead.next;
        //当快指针和慢指针到了同一个node时出循环
        while(fast!=slow){
            //快指针到头了，next==null说明必然没有环
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        //快指针返回到头，以正常速度走，与慢指针相遇的点就是带环节点
        fast=pHead;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
}
