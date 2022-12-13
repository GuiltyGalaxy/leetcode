package daily.L931;

class Solution {

    private static int M;
    private static int N;

    private static int[][] DP;

    private static int[][] MATRIX;


    public int minFallingPathSum(int[][] matrix) {
        N = matrix.length;
        M = matrix[0].length;
        MATRIX = matrix;
        DP = new int[N][M];
        int minSum = Integer.MAX_VALUE;
        //把不同起點的狀況都算過一遍
        for (int j = 0; j < M; j++) {
            minSum = Math.min(minSum, help(0, j));
        }
        return minSum;
    }

    private int help(int row, int col) {

        //算到最後一行沒有下一行可選，所以回傳自己即可
        if (row == N - 1 && col >= 0 && col <= M - 1) {
            return MATRIX[row][col];
        }

        //邊緣檢測，因累加數字不可能超過Integer.MAX_VALUE所以回傳這個
        if (row >= N || col < 0 || col >= M) {
            return Integer.MAX_VALUE;
        }

        //已算過不再計算
        if (DP[row][col] != 0) {
            return DP[row][col];
        }

        //往下一行計算
        int toL = help(row + 1, col - 1);
        int toM = help(row + 1, col);
        int toR = help(row + 1, col + 1);

        //該點最佳解是3種走法中選最小加本點
        return DP[row][col] = MATRIX[row][col] + Math.min(Math.min(toL, toM), toR);
    }
}