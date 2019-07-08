package swordfingeroffer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 */

public class RebuildBinaryTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 1、前序pre构建root节点
     * 2、在中序vin中找到root节点，
     * 3、root分割左右部分，分别进行递归构建。
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        //开启递归
        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }

    /**
     * 每次递归都返回一个当前root
     * @param pre
     * @param startPre
     * @param endPre
     * @param in
     * @param startIn
     * @param endIn
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

        if(startPre>endPre||startIn>endIn){
            return null;
        }
        int val=pre[startPre];
        TreeNode root=new TreeNode(val);
        //从中序数组中找，看看有没有和root相同的
        for(int i=startIn;i<=endIn;i++){
            if(val==in[i]){
                //下面的索引变换画个图就明白了！
                //处理root前面的一串
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                //处理root后面的一串
                root.right=reConstructBinaryTree(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
                //中序遍历数组中找了的对应的root，使命就结束了
                break;
            }
        }
        return root;
    }

}
