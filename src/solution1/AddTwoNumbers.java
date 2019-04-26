package solution1;


/**
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，
 * 并且它们的每个节点只能存储一位数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head1=l1;
        ListNode head2=l2;
        //类似于空的头节点，方便操作
        ListNode dumpHead=new ListNode(0);
        //结果链表
        ListNode cur=dumpHead;
        int carry=0;
        //两个链表同时遍历，直到最长的结束
        while(head1!=null||head2!=null){
            int num1=head1==null?0:head1.val;
            int num2=head2==null?0:head2.val;
            int sum=num1+num2+carry;
            //控制是否进位
            carry=sum/10;
            //每个节点的value一定是一个数字
            cur.next=new ListNode(sum%10);
            cur=cur.next;
            if(head1!=null){
                head1=head1.next;
            }
            if(head2!=null){
                head2=head2.next;
            }
        }
        //两个链表刚好等长，刚好需要进位的情况
        if(carry>0){
            cur.next=new ListNode(carry);
        }
        return dumpHead.next;
    }


    public static void main(String[] args) {
        ListNode head1=new ListNode(2);
        head1.next=new ListNode(4);
        head1.next.next=new ListNode(3);

        ListNode head2=new ListNode(5);
        head2.next=new ListNode(6);
        head2.next.next=new ListNode(4);
        ListNode cur=addTwoNumbers(head1,head2);
        while(cur!=null){
            if(cur.next==null){
                System.out.print(cur.val);
                return;
            }
            System.out.print(cur.val+"->");
            cur=cur.next;
        }
    }
}
