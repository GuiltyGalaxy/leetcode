package contest.bc136.L3239;


class Solution {

    private int flips(int[] grid) {
        int res = 0;
        for (int i = 0; i < grid.length / 2; i++) {
            // 只要不一樣就計算一次
            // 翻0或1都沒差
            if (grid[i] != grid[grid.length - i - 1]) {
                res++;
            }
        }
        return res;
    }

    private int rowPalindromic(int[][] grid, int n, int m) {
        int count_row = 0;
        for (int i = 0; i < n; i++) {
            count_row += flips(grid[i]);
        }
        return count_row;
    }

    private int colPalindromic(int[][] grid, int n, int m) {
        int count_col = 0;
        for (int i = 0; i < m; i++) {
            // 轉換一層
            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                col[j] = grid[j][i];
            }
            count_col += flips(col);
        }
        return count_col;
    }

    public int minFlips(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        // 排除例外
        if (n == 1 || m == 1) {
            return 0;
        }

        // row跟col都算過一遍取最小
        return Math.min(rowPalindromic(grid, n, m), colPalindromic(grid, n, m));
    }
}