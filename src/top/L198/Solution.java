package top.L198;

class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        // 初始化起點與偷第一家的結果
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 取dp[i]代表跳過這家
            // dp[i - 1] + nums[i]代表這家要偷(這樣上一家就不能偷了所以用dp[i - 1])
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[nums.length];
    }
}