package swordfingeroffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class PrintBinaryTreeByRow {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 主要是引入了两个变量，保证start~end只存一层的节点
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return res;
        }
        Queue<TreeNode> help = new LinkedList<TreeNode>();
        ArrayList<Integer> curList = new ArrayList<Integer>();
        help.add(pRoot);
        int start = 0, end = 1;
        while (!help.isEmpty()){
            TreeNode cur=help.remove();
            curList.add(cur.val);
            if(cur.left!=null){
                help.add(cur.left);
            }
            if(cur.right!=null){
                help.add(cur.right);
            }
            start++;
            if(start==end){
                start=0;
                end=help.size();
                res.add(curList);
                curList=new ArrayList<>();
            }
        }
        return res;
    }
}
