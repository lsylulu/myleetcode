package swordfingeroffer;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalancedTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class ResultData{
        int deep;
        boolean isBalanced;

        public ResultData(int deep,boolean isBalanced){
            this.deep=deep;
            this.isBalanced=isBalanced;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        ResultData resultData=isBalancedTree(root);
        return resultData.isBalanced;
    }

    public ResultData isBalancedTree(TreeNode root){
        ResultData res=new ResultData(0,true);
        if(root==null){
            return res;
        }
        if(!isBalancedTree(root.left).isBalanced){
            return new ResultData(-1,false);
        }
        if(!isBalancedTree(root.right).isBalanced){
            return new ResultData(-1,false);
        }
        if(Math.abs(isBalancedTree(root.left).deep-isBalancedTree(root.right).deep)>1){
            return new ResultData(-1,false);
        }
        return new ResultData(Math.max(isBalancedTree(root.left).deep,isBalancedTree(root.right).deep)+1,true);
    }
}
