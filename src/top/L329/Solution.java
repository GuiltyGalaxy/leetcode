package top.L329;

class Solution {

    public int longestIncreasingPath(int[][] matrix) {

        int[][] max = new int[matrix.length][matrix[0].length];

        int res = 1;

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (max[i][j] == 0) {
                    res = Math.max(res, dfs(matrix, max, i, j));
                }
            }
        }

        return res;
    }

    private int dfs(int[][] matrix, int[][] max, int i, int j) {

        int res = 1;
        // 去檢查4個方向的max，來計算該格的max是多少
        int[][] dirt = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        for (int[] d : dirt) {
            int row = i + d[0];
            int col = j + d[1];
            if (row < 0 || row == matrix.length || col < 0 || col == matrix[0].length) {
                continue;
            }
            // 前一格要大於當前才計算
            if (matrix[row][col] <= matrix[i][j]) {
                continue;
            }
            if (max[row][col] > 0) {
                // 上一格被走過直接用max計算
                res = Math.max(res, max[row][col] + 1);
            } else {
                // 沒計算過則以該點為基準繼續往下算
                res = Math.max(res, dfs(matrix, max, row, col) + 1);
            }
        }
        // 被最後結果更新到該點max上
        max[i][j] = res;

        return res;
    }
}