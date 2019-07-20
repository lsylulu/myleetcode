package swordfingeroffer;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * <p>
 * 二叉树的镜像定义：源二叉树
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * 镜像二叉树
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 */
public class MirrorOfBinaryTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 先序遍历时将左右子节点交换
     *
     * @param root
     */
    public static void Mirror(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        change(root);
        Mirror(root.left);
        Mirror(root.right);
    }

    public static void change(TreeNode root) {

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
