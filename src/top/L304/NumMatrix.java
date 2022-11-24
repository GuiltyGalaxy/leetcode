package top.L304;

class NumMatrix {

    private int[][] dp;

    //https://leetcode.com/problems/range-sum-query-2d-immutable/discuss/75358/Clean-and-easy-to-understand-java-solution
    public NumMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        // matrix
        // 3 0 1 4 2
        // 5 6 3 2 1
        // 1 2 0 1 5
        // 4 1 0 1 7

        // dp
        // 0 0 0  0  0  0
        // 0 3 3  4  8
        // 0 8 14 18
        // 0 9 17 21
        // 0 13
        dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int iMin = Math.min(row1, row2);
        int iMax = Math.max(row1, row2);

        int jMin = Math.min(col1, col2);
        int jMax = Math.max(col1, col2);

        return dp[iMax + 1][jMax + 1] - dp[iMax + 1][jMin] - dp[iMin][jMax + 1] + dp[iMin][jMin];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */