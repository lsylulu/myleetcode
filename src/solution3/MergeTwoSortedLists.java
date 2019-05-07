package solution3;


/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    static class ListNode{
        int value;
        ListNode next;
        public ListNode(int value){
            this.value=value;
        }
    }

    /**
     * 合并过程类似于归并的合并
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //新建一个空链表
        ListNode res=new ListNode(-1);
        ListNode cur=res;
        while(l1!=null&&l2!=null){
            if(l1.value<l2.value){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        //将长的链表直接赋值到后面
        cur.next=l1==null?l2:l1;
        return res.next;
    }
}
