package top.L377;

class Solution {

    /**
     * DP解
     * 概念為
     * 如果nums到3有2種可能
     * 到2有1種可能
     * 那到5就有3種可能
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        // 1一定有個解，所以從1開始
        dp[0] = 1;
        // 把到target的可能性都算過一遍
        for (int i = 1; i <= target; i++) {
            // 每次都把所有數字嘗試過一遍
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

}