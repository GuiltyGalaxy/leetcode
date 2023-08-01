package top.L51;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    private final List<List<String>> res = new ArrayList<>();
    // 棋盤狀態
    private char[][] board;
    // 紀錄row還可不可以放
    private int[] rowCheck;
    // 紀錄↙方向是否可以放
    private int[] rLineCheck;
    // 紀錄↘方向是否可以放
    private int[] lLineCheck;
    private int maxCol;

    // 我覺得該解法奇妙的點是有辦法利用一個1-D Array去紀錄斜線可不可以下
    public List<List<String>> solveNQueens(int n) {
        // 初始化棋盤
        maxCol = n;
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        rowCheck = new int[n];
        // 斜線的數量會是2 * n - 1
        // ex. 4*4 的格盤會有7條斜線
        rLineCheck = new int[2 * n - 1];
        lLineCheck = new int[2 * n - 1];
        // 以col=0當基準點依序擺上Q
        nextStep(0);
        return res;
    }

    private void nextStep(int col) {

        // col到結尾代表沒有可以下的
        // 把該答案紀錄
        if (col == maxCol) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < maxCol; row++) {
            if (check(row, col)) {
                setQueen(true, row, col);
                nextStep(col + 1);
                setQueen(false, row, col);
            }
        }
    }

    /**
     * 檢查是否可下在該點
     */
    private boolean check(int row, int col) {
        return rowCheck[row] == 0
                && rLineCheck[row + col] == 0
                && lLineCheck[maxCol - 1 + col - row] == 0;
    }

    /**
     * 將Q下在某個位子或是移除
     */
    private void setQueen(boolean setQueen, int row, int col) {
        int set = setQueen ? 1 : 0;
        board[row][col] = setQueen ? 'Q' : '.';
        rowCheck[row] = set;
        // 該方向斜線比較好懂，row + col就可以
        rLineCheck[row + col] = set;
        // 首先假設col = row = 0時要在中間
        // 所以基準點是maxCol - 1
        lLineCheck[maxCol - 1 + col - row] = set;
    }

    private List<String> construct(char[][] board) {
        List<String> tmp = new LinkedList<>();
        for (char[] chars : board) {
            String s = new String(chars);
            tmp.add(s);
        }
        return tmp;
    }
}