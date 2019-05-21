package solution5;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class RotateImage {

    /**
     * 任意一个(i,j) , (j, n-i-1), (n-i-1, n-j-1), (n -j-1, i)就是这四个索引号上的数交换
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int len=matrix.length;
        //一次循环转len个点，总共循环len次
        for(int i=0;i<len;i++){
            //本行第一个元素索引
            int start =i;
            //本行最后一个元素索引
            int end=len-i-1;
            for(int j=i;j<end-start;j++){
                //记录要旋转的那个元素
                int temp= matrix[start+j][start];
                matrix[start][start+j]=matrix[end-j][start];
                matrix[end-j][start]=matrix[end][end-j];
                matrix[end][end-j]=matrix[start+j][end];
                matrix[start+j][end]=temp;

                for(int k=0;k<len;k++){
                    for (int o=0;o<len;o++){

                        System.out.print(matrix[k][o]+" ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        rotate(matrix);
    }
}
