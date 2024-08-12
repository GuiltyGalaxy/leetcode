package contest.wc410.L3250;


class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int countOfPairs(int[] nums) {

        int n = nums.length;
        // 記錄在長度剩下n時的對應數字可能性有多少
        // 由於範圍只有0 - 50所以開51
        int[][] dp = new int[n][51];

        // 從最後開始算
        for (int i = n - 1; i >= 0; i--) {
            // 把該數字的可能性都算過
            for (int j = 0; j <= nums[i]; j++) {
                // 一開始先初始化dp，所有可能性都為1
                if (i == n - 1) {
                    dp[i][j] = 1;
                } else {
                    // 依照前一個dp結果更新當前dp
                    // k的起始值要去看說 nums[i + 1] - nums[i] + j會不會比單純的j大
                    // 前一個數字如果比後面，那當前k的可能性就會被縮減
                    // k <= nums[i + 1]不能大於前個數字
                    for (int k = Math.max(j, nums[i + 1] - nums[i] + j); k <= nums[i + 1]; k++) {
                        dp[i][j] = (dp[i][j] + dp[i + 1][k]) % MOD;
                    }
                }
            }
        }
        // 把全部結果累加
        int res = 0;
        for (int i = 0; i <= nums[0]; i++) {
            res = (res + dp[0][i]) % MOD;
        }
        return res;
    }
}