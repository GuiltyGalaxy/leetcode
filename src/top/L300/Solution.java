package top.L300;

import java.util.Arrays;

class Solution {

    /**
     * DP解法
     * O(n^2)
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 1;

        // 初始化DP
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 只要後大前就符合
                if (nums[j] < nums[i]) {
                    // 更新DP
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    /**
     * brainy search解法
     * O(n log n)
     */
    public int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;

        for (int num : nums) {
            int left = 0;
            // 查找範圍為size
            int right = size;

            // 透過二分法來決定該num要放置於tails哪個位子
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // 將該數放置
            tails[left] = num;
            // 如果left == size代表最大長度有更新
            if (left == size) {
                size++;
            }
        }

        return size;
    }
}