package contest.wc405.L3212;


class Solution {
    public int numberOfSubmatrices(char[][] grid) {

        // 紀錄從起始點所有的x y個數
        int[][][] dp = new int[grid.length][grid[0].length][2];
        int ans = 0;

        for (int row = 0; row < grid.length; row++) {
            // 每次開始算的時候都要初始化
            int x = 0;
            int y = 0;
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 'X') {
                    x++;
                }
                if (grid[row][col] == 'Y') {
                    y++;
                }
                // 除了row=0沒有上一個row可以參考
                // 剩下的row都需要參考上一個row去更新dp
                dp[row][col][0] = dp[row == 0 ? 0 : row - 1][col][0] + x;
                dp[row][col][1] = dp[row == 0 ? 0 : row - 1][col][1] + y;
            }
        }

        for (int[][] row : dp) {
            for (int[] col : row) {
                // 只要x=y，且x>0就符合要求
                if (col[0] == col[1] && col[0] > 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}