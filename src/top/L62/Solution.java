package top.L62;

class Solution {
    public int uniquePaths(int m, int n) {

        int[][] ans = new int[m][n];

        //將row[0] col[0]初始化成 1
        for (int i = 0; i < m; i++) {
            ans[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            ans[0][i] = 1;
        }

        //當前格子相加前一個格子的可能路徑數就為當前個子的可能路徑數
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ans[i][j] = ans[i - 1][j] + ans[i][j - 1];
            }
        }

        //回傳最終格結果
        return ans[m - 1][n - 1];
    }
}