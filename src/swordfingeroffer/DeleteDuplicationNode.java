package swordfingeroffer;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplicationNode {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        //辅助节点
        ListNode head = new ListNode(-1);
        head.next = pHead;
        //当前一定不重复的节点
        ListNode pre = head;
        //向后搜索的指针，直到不重复为止
        ListNode last = head.next;
        while (last != null) {
            if (last.next != null && last.next.val == last.val) {
                //找到最后一个相同的节点
                while (last.next != null && last.next.val == last.val){
                    last=last.next;
                }
                //last是不能留的
                pre.next=last.next;
                last=last.next;
            }else {
                //当前last不重复的情况
                pre=pre.next;
                last=last.next;
            }
        }
        return head.next;
    }
}
