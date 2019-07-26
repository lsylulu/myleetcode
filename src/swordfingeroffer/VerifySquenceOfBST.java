package swordfingeroffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if ( sequence==null || sequence.length<=0 ) {
            return false;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length-1);
    }

    private boolean VerifySquenceOfBST(int [] sequence, int start, int end){

        if ( start>=end ){
            return true;
        }

        int root = sequence[end];

        int i=start;
        //保证i左边的都比root小
        while( sequence[i] < root ){
            i++;
        }

        int j=i;
        while( j<end ){
            if ( sequence[j]<root ) {
                return false;
            }
            j++;
        }

        boolean left = VerifySquenceOfBST(sequence, start, i-1);
        boolean right = VerifySquenceOfBST(sequence, i, end-1);
        return left && right;
    }
}
