package solution2;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class RemoveNodeFromEnd {

    static class ListNode{
        int value;
        ListNode next;
        public ListNode(int value){
            this.value=value;
        }
    }

    /**
     * 删除倒数第n个节点并返回头节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp = head;
        int size = 0;
        //先算出链表的长度
        while (temp!= null) {
            temp = temp.next;
            size++;
        }
        //倒数的刚好是第一个，直接删除
        //返回下一个
        if (n == size) {
            return head.next;
        }

        temp = head;
        //找到要删除节点的前一个节点位置
        int cut = size - n;
        //判断指针到达要删除元素的前一个位置，进行链表删除操作
        while (cut-- > 1) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
            return head;
        }
        return null;
    }
}
