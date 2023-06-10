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
        // 主要四邊都去走
        // 如果周邊有曾經走過的結果則依該結果判斷大小
        // 比較大就+1當成該格基準點
        // 第一次走的方向為基準所以就不用加上max判斷
        // 上
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            if (max[i - 1][j] > 0) {
                res = max[i - 1][j] + 1;
            } else {
                res = dfs(matrix, max, i - 1, j) + 1;
            }
        }
        // 左
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            if (max[i][j - 1] > 0) {
                res = Math.max(max[i][j - 1] + 1, res);
            } else {
                res = Math.max(res, dfs(matrix, max, i, j - 1) + 1);
            }
        }
        // 下
        if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {
            if (max[i + 1][j] > 0) {
                res = Math.max(max[i + 1][j] + 1, res);
            } else {
                res = Math.max(dfs(matrix, max, i + 1, j) + 1, res);
            }
        }
        // 右
        if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]) {
            if (max[i][j + 1] > 0) {
                res = Math.max(max[i][j + 1] + 1, res);
            } else {
                res = Math.max(dfs(matrix, max, i, j + 1) + 1, res);
            }
        }
        max[i][j] = res;

        return res;
    }
}