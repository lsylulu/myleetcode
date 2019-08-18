package swordfingeroffer;


/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class ConvertBSTToLinkedList {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    private TreeNode pre=null;
    private TreeNode head=null;

    public TreeNode Convert(TreeNode pRootOfTree) {

        inOrder(pRootOfTree);
        return head;

    }

    /**
     * 中序遍历，过程中处理当前节点的前驱和后继，然后将pre设为当前节点
     * @param node
     */
    public void inOrder(TreeNode node) {

        if(node==null){
            return;
        }
        inOrder(node.left);
        node.left=pre;
        if(pre!=null){
            pre.right=node;
        }
        pre=node;
        if(head==null){
            head=node;
        }
        inOrder(node.right);
    }
}
