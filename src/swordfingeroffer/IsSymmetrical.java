package swordfingeroffer;

public class IsSymmetrical {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null || (pRoot.left == null && pRoot.right == null)) {
            return true;
        }
        return judge(pRoot.left,pRoot.right);
    }

    boolean judge(TreeNode left,TreeNode right) {
        if (left == null ) {
            return right==null;
        }
        //左子树不为空，有子树为空，不然不是对称的
        if (right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return judge(left.left,right.right) && judge(left.right,right.left);
    }
}
