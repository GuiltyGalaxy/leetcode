package top.L70;

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        // 0為起始點設為1
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}