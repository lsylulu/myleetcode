package swordfingeroffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom {

     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> help = new LinkedList<>();
        if (root == null) {
            return res;
        }
        help.add(root);
        while (help.size() != 0) {
            TreeNode temp = ((LinkedList<TreeNode>) help).pop();
            if (temp.left != null){
                help.add(temp.left);
            }
            if (temp.right != null) {
                help.add(temp.right);
            }
            res.add(temp.val);
        }
        return res;
    }
}
