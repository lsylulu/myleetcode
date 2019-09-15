package swordfingeroffer;

import java.util.Stack;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNextNode {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        //父节点的指针
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * 有右子树，则找右子树最左的孩子；没右子树，则找父节点的，并且当前节点必须是父节点的左孩子
     * 找到符合的父节点后，父节点就是下一个中序的节点
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        if(pNode==null){
            return null;
        }
        if(pNode.right!=null){
            pNode=pNode.right;
            while (pNode.left!=null){
                pNode=pNode.left;
            }
            return pNode;
        }
        while (pNode.next!=null){
            if(pNode.next.left==null){
                return pNode;
            }
            pNode=pNode.next;
        }
        //根节点，且无右孩子，则没有下一个中序的节点
        return null;
    }
}
