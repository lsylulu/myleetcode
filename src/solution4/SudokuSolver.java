package solution4;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {

        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];

        //初始化，有数字的都是true
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    col[j][num] = true;
                    // blockIndex = i / 3 * 3 + j / 3，取整
                    block[i / 3 * 3 + j / 3][num] = true;
                }
            }
        }
        //再一个一个试探，放入
        tryPut(board,row,col,block,0,0);
    }

    private boolean tryPut(char[][] board,boolean[][] row, boolean[][] col, boolean[][] block,int i,int j) {

        //试探，找到下一个空位置
        //返回true则代表没位置了，已经填完了
        while (board[i][j]!='.'){
            if (++j >= 9) {
                i++;
                j = 0;
            }
            if (i >= 9) {
                return true;
            }
        }

        //在空白位置添加数字,添加前先验证是否符合要求
        for (int num = 1; num <= 9; num++) {
            int blockIndex = i / 3 * 3 + j / 3;
            if (!row[i][num] && !col[j][num] && !block[blockIndex][num]) {
                //先添加进去
                board[i][j] = (char) ('0' + num);
                row[i][num] = true;
                col[j][num] = true;
                block[blockIndex][num] = true;
                if (tryPut(board, row, col, block, i, j)) {
                    return true;
                } else {
                    // 回溯
                    row[i][num] = false;
                    col[j][num] = false;
                    block[blockIndex][num] = false;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }


}
