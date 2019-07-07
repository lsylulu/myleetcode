package swordfingeroffer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class SearchTwoDimensionalArray {

    /**
     * 从右上角开始找，查找过程中row必然会增大
     * col必然会减小，所以需要判断边界
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {

        int row=0;
        int col=array[0].length-1;
        while (row<=array.length-1&&col>=0){
            if(array[row][col]==target){
                return true;
            }else if(array[row][col]>=target){
                col--;
            }else {
                row++;
            }
        }
        return false;
    }
}
