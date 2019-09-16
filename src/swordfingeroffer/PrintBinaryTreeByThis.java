package swordfingeroffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintBinaryTreeByThis {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(pRoot);
        Stack<TreeNode> s2 = new Stack<>();
        int count = 1;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            //如果是奇数则将当前节点左右入栈，这样处理后，出栈时的顺序就是先右后左
            if (count % 2 != 0) {
                ArrayList<Integer> temp=new ArrayList();
                while (!s1.isEmpty()) {
                    TreeNode node = s1.pop();
                    if(node!=null){
                        temp.add(node.val);
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if(!temp.isEmpty()){
                    count++;
                    res.add(temp);
                }
            }else {
                ArrayList<Integer> temp=new ArrayList();
                while (!s2.isEmpty()) {
                    TreeNode node = s2.pop();
                    if(node!=null){
                        temp.add(node.val);
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if(!temp.isEmpty()){
                    count++;
                    res.add(temp);
                }
            }
        }
        return res;
    }

}
