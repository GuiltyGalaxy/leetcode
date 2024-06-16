package top.L53;

class Solution {
    public int maxSubArray(int[] nums) {

        // 預設從0開始
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 當currentSum加上nums[i]比原先nums[i]還小則重新以nums[i]繼續計算
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

}