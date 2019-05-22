package solution6;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 */
public class NQueens {

    //    public static List<List<String>> solveNQueens(int n) {
//        List<List<String>> res=new ArrayList<>();
//        if(n<1){
//            return res;
//        }
//        dfs(n,0,new ArrayList<Integer>(),res);
//        return res;
//    }
//
//    /**
//     *
//     * @param n
//     * @param x 数组索引
//     * @param state
//     * @param res
//     */
//    private static void dfs(int n, int x, List<Integer> state, List<List<String>> res) {
//        if(n==x){
//            generateSolution(state,n,res);
//            return;
//        }
//        for(int i=0;i<n;i++){
//            if(valid(x,i,state)){
//                state.add(i);
//                dfs(n,x+1,state,res);
//                //调用结束则移除该点
//                state.remove(state.size()-1);
//            }
//        }
//    }
//
//    /**
//     *
//     * @param x 数组索引
//     * @param y 数组的值
//     * @param state
//     * @return
//     */
//    private static boolean valid(int x, int y, List<Integer> state) {
//        for(int i=0;i<state.size();i++){
//            //当y等于皇后所在的位置
//            if(y==state.get(i)){
//                return false;
//            }
//            if(Math.abs(y-state.get(i))==Math.abs(x-i)){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private static void generateSolution(List<Integer> state, int n, List<List<String>> res) {
//        List<String> solution=new ArrayList<>();
//        for(Integer x:state){
//            StringBuilder sb=new StringBuilder();
//            for(int i=0;i<x;i++){
//                sb.append(".");
//            }
//            sb.append("Q");
//            for(int i=x+1;i<n;i++){
//                sb.append(".");
//            }
//            solution.add(sb.toString());
//        }
//        res.add(solution);
//    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        int[] arr = new int[n];
        putQueen(list, 0, n, arr);
        return list;
    }


    /**
     * 尝试放置：递归+回溯
     * @param list
     * @param row
     * @param n
     * @param arr 记录每行的皇后在第几列，索引代表第几行，值代表第几列
     */
    public static void putQueen(List<List<String>> list, int row, int n, int[] arr) {

        //递归结束条件，当下一行就是n时，找到了有效解
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {

                    if (arr[i] == j) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                temp.add(sb.toString());
            }
            list.add(temp);
            for(int k=0;k<arr.length;k++){
                System.out.print(arr[k]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            //用横坐标表示纵坐标
            //i是列，row是行
            arr[row] = i;
            if (check(arr, row)) {
                System.out.println("row="+row);
                System.out.println("i="+i);
                putQueen(list, row + 1, n, arr);
            }
        }
    }

    /**
     * 检测放置的皇后是否有问题
     * @param arr
     * @param row
     * @return
     */
    public static boolean check(int[] arr, int row) {
        for (int i = 0; i < row; i++) {
            if (arr[i] == arr[row] || Math.abs(row - i) == Math.abs(arr[row] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        solveNQueens(4);
    }

}
