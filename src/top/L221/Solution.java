package top.L221;

class Solution {

    public int maximalSquare(char[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSide = 0;
        // 紀錄每個dp的最大maxSide
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        // 由於沒有上個可以參考所以設成1
                        dp[i][j] = 1;
                    } else {
                        // 檢查0 1 2取最小邊界
                        // 0 1
                        // 2 i,j
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }

                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }
}