package swordfingeroffer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：
 * 1  2  3  4
 * 5  6  7  8
 * 9 10 11 12
 * 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {

    /**
     * 可以按圈打印，只需要直到左上角和右下角的点，就能打印一圈
     * 寻找下一层时可以将左上角的点向右下角移动，右下角的点向左上角移动
     *
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> printMatrix(int[][] matrix) {

        ArrayList<Integer> res=new ArrayList<>();
        //左上角的行
        int lur = 0;
        //左上角的列
        int luc = 0;
        //右下角的行
        int rdr = matrix.length-1;
        //右下角的列
        int rdc = matrix[0].length-1;
        //当左上角的行大于右上角的行或左上角的列大于右上角的列时，打印结束
        while (lur <= rdr && luc <= rdc) {
            printMatrix(matrix, lur, luc, rdr, rdc,res);
            lur++;
            luc++;
            rdr--;
            rdc--;
        }
        return res;
    }

    public static void printMatrix(int[][] matrix, int lur, int luc, int rdr, int rdc,ArrayList<Integer> res) {
        //两个点在同一行的情况
        if (lur == rdr) {
            for (int i = luc; i <=rdc;i++){
                res.add(matrix[lur][i]);
//                System.out.println(matrix[lur][i]);
            }
        }else if (luc == rdc){
            //两个点在同一列
            for (int i = lur; i <=rdr;i++){
                res.add(matrix[i][luc]);
//                System.out.println(matrix[i][luc]);
            }
        }else{
            //正常情况，4个while
            int cur=lur;
            int cuc=luc;
            while(cuc!=rdc){
                res.add(matrix[lur][cuc]);
                cuc++;
            }
            while(cur!=rdr){
                res.add(matrix[cur][rdc]);
                cur++;
            }
            while(cuc!=luc){
                res.add(matrix[rdr][cuc]);
                cuc--;
            }
            while(cur!=lur){
                res.add(matrix[cur][luc]);
                cur--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        ArrayList<Integer> arr=printMatrix(matrix);
        for (Integer integer : arr) {
            System.out.print(integer+" ");
        }
    }
}
