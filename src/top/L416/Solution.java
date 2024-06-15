package top.L416;

class Solution {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // sum為even則不可能切割
        if (sum % 2 != 0) {
            return false;
        }

        // target為兩等分的結果
        int target = sum / 2;
        // dp[n]代表意思為數字n是否有可以達到該數的可能
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        // 把所有num可能性算過
        for (int num : nums) {
            // 必須從後開始逆向紀錄dp，避免數字被重複使用
            for (int t = target; t >= num; t--) {
                // dp[j - num]意思為如果target-num是否之前有dp可達到
                // dp[t]要加入判斷，可能這個數不能但先前有其他數字可以達到
                dp[t] = dp[t] || dp[t - num];
            }
        }

        return dp[target];
    }
}