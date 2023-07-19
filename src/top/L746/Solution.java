package top.L746;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        return Math.min(helper(cost, 0, dp), helper(cost, 1, dp));
    }

    private int helper(int[] cost, int i, int[] dp) {

        if (i >= cost.length) {
            return 0;
        }
        // 已經計算過就不再計算
        if (dp[i] != 0) {
            return dp[i];
        }
        // 往下計算1步與2步的結果
        int oneStep = cost[i] + helper(cost, i + 1, dp);
        int twoStep = cost[i] + helper(cost, i + 2, dp);
        // 回傳之間較小值
        return dp[i] = Math.min(oneStep, twoStep);
    }
}