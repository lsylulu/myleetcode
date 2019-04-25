package solution1;


import java.util.Stack;

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
//        ListNode head1=reverseList(l1);
//        ListNode head2=reverseList(l2);

        ListNode cur=l1;
        int count=1;
        int num1=cur.val*count;
        while(cur.next!=null){
            cur=cur.next;
            count=count*10;
            num1+=cur.val*count;
        }

        cur=l2;
        count=1;
        int num2=cur.val*count;
        while(cur.next!=null){
            cur=cur.next;
            count=count*10;
            num2+=cur.val*count;
        }

        ListNode res=transToList(Integer.toString(num1+num2));
        return res;
    }

    /**
     * 将数字入栈，并逆序
     * @param str
     * @return
     */
    public static ListNode transToList(String str){
        char[] arr=str.toCharArray();
        ListNode head=new ListNode(Integer.parseInt(String.valueOf(arr[0])));
        ListNode cur=head;

        //构建链表
        for(int i=0;i<arr.length-1;i++){
            ListNode next=new ListNode(Integer.parseInt(String.valueOf(arr[i+1])));
            cur.next=next;
            cur=cur.next;
        }

        Stack<ListNode> help=new Stack<>();
        help.push(head);
        ListNode cur2=head;
        head.next=null;

        //将链表中的元素都先入栈
        while(cur2.next!=null){
            System.out.println(cur2.val+"---------");
            cur2=cur2.next;
            help.push(cur2);
        }
        //此时cur指向链表最后一个元素，也是栈顶元素
        head=cur2;
        cur2=help.pop();
        System.out.println(cur2.val+"---------");
        while (!help.isEmpty()){
            cur2.next=help.pop();
        }
        return head;
    }


//    /**
//     * 将链表中的元素逆序
//     * @param head
//     * @return
//     */
//    public static ListNode reverseList(ListNode head){
//        if(head==null){
//            return null;
//        }
//        Stack<ListNode> help=new Stack<>();
//        help.push(head);
//        ListNode cur=head;
//        head.next=null;
//        //将链表中的元素都先入栈
//        while(cur.next!=null){
//            cur=cur.next;
//            help.push(cur.next);
//        }
//        //此时cur指向链表最后一个元素，也是栈顶元素
//        head=cur;
//        cur=help.pop();
//        while (!help.isEmpty()){
//            cur.next=help.pop();
//
//        }
//        return head;
//    }

    public static void main(String[] args) {
        ListNode head1=new ListNode(2);
        head1.next=new ListNode(4);
        head1.next.next=new ListNode(3);

        ListNode head2=new ListNode(5);
        head2.next=new ListNode(6);
        head2.next.next=new ListNode(4);
//        addTwoNumbers(head1,head2);

        ListNode head=transToList("342");
        while (head!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }

    }
}
