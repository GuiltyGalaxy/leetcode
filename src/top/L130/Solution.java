package top.L130;

class Solution {

    private int M = 0;
    private int N = 0;

    public void solve(char[][] board) {

        M = board.length;
        N = board[0].length;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                //只要檢查起點為邊緣的'O'即可
                if (i == 0 || i == M - 1 || j == 0 || j == N - 1) {
                    check(board, j, i);
                }
            }
        }

        //剩下的'O'都是不合需求的
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        //把剛剛標記的'*'復原成'O'
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void check(char[][] board, int x, int y) {

        if (x < 0 || x >= N || y < 0 || y >= M) {
            return;
        }

        if (board[y][x] != 'O') {
            return;
        }

        board[y][x] = '*';
        check(board, x + 1, y);
        check(board, x - 1, y);
        check(board, x, y + 1);
        check(board, x, y - 1);
    }
}