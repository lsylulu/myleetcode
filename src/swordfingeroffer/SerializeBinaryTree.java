package swordfingeroffer;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static String Serialize(TreeNode root) {
        if(root==null){
            return "#!";
        }
        String res=root.val+"!";
        res+=Serialize(root.left);
        res+=Serialize(root.right);
        return res;
    }

    public TreeNode Deserialize(String str) {
        String[] element=str.split("!");
        Queue<String> queue=new LinkedList<>();
        //将所有的节点都添加到队列中，便于处理
        for(int i=0;i<element.length;i++){
            ((LinkedList<String>) queue).add(element[i]);
        }
        return reconPreOrder(queue);
    }

    /**
     * 具体的先序遍历反序列化方法
     * @param queue
     * @return
     */
    public TreeNode reconPreOrder(Queue<String> queue){
        String value=queue.poll();
        if(value.equals("#!")){
            return null;
        }
        TreeNode head=new TreeNode(Integer.valueOf(value));
        head.left=reconPreOrder(queue);
        head.right=reconPreOrder(queue);
        return head;
    }

}
