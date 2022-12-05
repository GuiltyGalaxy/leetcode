package top.L37;

class Solution {

    //記錄 row 是否有出現過該數字
    boolean[][] rows = new boolean[9][9];
    //記錄 col 是否有出現過該數字
    boolean[][] cols = new boolean[9][9];
    //記錄 box 是否有出現過該數字
    boolean[][] boxes = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        //先將出現過的數字做紀錄
        //這樣可以省去次都要找過是否重複的時間
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    rows[i][num] = cols[j][num] = boxes[(i / 3) * 3 + j / 3][num] = true;
                }
            }
        }
        solveSudoku(board, 0, 0);
    }

    private boolean solveSudoku(char[][] board, int i, int j) {
        // 換下一行
        if (j == 9) {
            i++;
            j = 0;
        }
        // 結束
        if (i == 9) {
            return true;
        }

        // 非數字則跳過
        if (board[i][j] != '.') {
            return solveSudoku(board, i, j + 1);
        }

        //計算目前在哪個九宮格
        int boxIndex = (i / 3) * 3 + j / 3;
        //把每個可能性都循過
        for (int num = 0; num < 9; num++) {
            //三種條件都沒出現過才可填入該數字
            if (!rows[i][num] && !cols[j][num] && !boxes[boxIndex][num]) {
                rows[i][num] = cols[j][num] = boxes[boxIndex][num] = true;
                board[i][j] = (char) (num + '1');
                //用該數字去解是否有答案
                if (solveSudoku(board, i, j)) {
                    return true;
                }
                //該數字無答案則重置回原始狀態
                rows[i][num] = cols[j][num] = boxes[boxIndex][num] = false;
                board[i][j] = '.';
            }
        }

        return false;
    }
}