package top.L213;

import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        // 環狀偷可拆分成兩種情況
        // 偷頭不偷尾
        int case1 = robs(Arrays.copyOfRange(nums, 0, nums.length - 1));
        // 偷尾不偷頭
        int case2 = robs(Arrays.copyOfRange(nums, 1, nums.length));
        // 取較大即可
        return Math.max(case1, case2);
    }

    /**
     * 該功能寫法與L198完全相同
     */
    private int robs(int[] num) {
        int[] dp = new int[num.length + 1];
        dp[0] = 0;
        dp[1] = num[0];
        for (int i = 1; i < num.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + num[i]);
        }
        return dp[num.length];
    }
}