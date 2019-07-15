package swordfingeroffer;

public class FindKthToTail {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 设置两个指针，一个快指针先走到k-1处，
     * 然后慢指针开始走，快指针到头了，慢指针所在的位置就是倒数第k个位置
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {

        if(head==null||k<=0){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        for(int i=1;i<k;i++){
            if(fast.next!=null){
                fast=fast.next;
            }else{
                return null;
            }
        }

        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
