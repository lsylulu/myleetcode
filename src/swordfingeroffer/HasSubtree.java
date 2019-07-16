package swordfingeroffer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 扫描整棵树，观察是否有相等的节点
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        boolean res = false;
        if (root2 != null && root1 != null) {
            if (root1.val == root2.val) {
                res = doesTree1HasTree2(root1, root2);
            }
            if (!res) {
                res = HasSubtree(root1.left, root2);
            }
            if (!res) {
                res = HasSubtree(root1.right, root2);
            }
        }
        return res;
    }

    /**
     * 如果根节点匹配上了，就走这个方法，比较子树是否相等
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {

        //root2遍历完了
        if (root2 == null) {
            return true;
        }
        //root2没遍历完，root1已经遍历完了
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        //根节点正确了，对应的左右子节点也必须正确
        return doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);
    }

}
