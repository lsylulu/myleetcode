package solution6;

import java.util.ArrayList;
import java.util.List;

/**
 * 就是上一题的变种，基本一样
 * 这里直接贴另一种方法
 */
public class NQueensii {

//    public int totalNQueens(int n) {
//        List<List<String>> list = new ArrayList<>();
//        int[] arr = new int[n];
//        putQueen(list, 0, n, arr);
//        return list.size();
//    }
//
//
//    /**
//     * 尝试放置：递归+回溯
//     *
//     * @param list
//     * @param row
//     * @param n
//     * @param arr  记录每行的皇后在第几列，索引代表第几行，值代表第几列
//     */
//    public static void putQueen(List<List<String>> list, int row, int n, int[] arr) {
//
//        //递归结束条件，当下一行就是n时，找到了有效解
//        if (row == n) {
//            List<String> temp = new ArrayList<>();
//            for (int i = 0; i < n; i++) {
//                StringBuilder sb = new StringBuilder();
//                for (int j = 0; j < n; j++) {
//
//                    if (arr[i] == j) {
//                        sb.append("Q");
//                    } else {
//                        sb.append(".");
//                    }
//                }
//                temp.add(sb.toString());
//            }
//            list.add(temp);
//
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//            //用横坐标表示纵坐标
//            //i是列，row是行
//            arr[row] = i;
//            if (check(arr, row)) {
//
//                putQueen(list, row + 1, n, arr);
//            }
//        }
//    }
//
//    /**
//     * 检测放置的皇后是否有问题
//     *
//     * @param arr
//     * @param row
//     * @return
//     */
//    public static boolean check(int[] arr, int row) {
//        for (int i = 0; i < row; i++) {
//            if (arr[i] == arr[row] || Math.abs(row - i) == Math.abs(arr[row] - arr[i])) {
//                return false;
//            }
//        }
//        return true;
//    }

    /**
     * 记录某列是否已有皇后摆放
     */
    private static boolean col[];

    /**
     * 记录某条正对角线（左上右下）是否已有皇后摆放（某条对角线对应的摆放位置为 x - y + n - 1）
     */
    private static boolean dia1[];

    /**
     * 记录某条斜对角线（左下右上）是否已有皇后摆放（某条对角线对应的摆放位置为 x + y）
     */
    private static boolean dia2[];

    public static int totalNQueens(int n) {
        // 依然可以使用 51 号问题的解决思路，但问题是有没有更好的方法
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        return putQueen(n, 0);
    }

    /**
     * 递归回溯方式摆放皇后
     *
     * @param n     待摆放皇后个数
     * @param index 已摆放皇后个数
     */
    private static int putQueen(int n, int index) {
        int res = 0;
        if (index == n) {
            return 1;
        }
        // 表示在 index 行的第 i 列尝试摆放皇后
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[i - index + n - 1] && !dia2[i + index]) {
                // 递归
                col[i] = true;
                dia1[i - index + n - 1] = true;
                dia2[i + index] = true;
                res += putQueen(n, index + 1);
                // 回溯
                col[i] = false;
                dia1[i - index + n - 1] = false;
                dia2[i + index] = false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = totalNQueens(8);
        System.out.println(n);
    }
}
