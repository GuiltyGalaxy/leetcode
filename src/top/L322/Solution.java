package top.L322;

import java.util.Arrays;

class Solution {

    /**
     * 使用DP解(Iteration bottom-up)
     */
    public int coinChange(int[] coins, int amount) {

        // dp[a] = b
        // a:金額
        // b:最小換錢硬幣數
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);
        // 0不用任何硬幣
        dp[0] = 0;
        // 從最小開始換
        for (int coin : coins) {
            // 比較coin到amount換過一遍的結果
            for (int i = coin; i <= amount; i++) {
                // 取i - coin硬幣的數量
                // +1代表說替換成該硬幣
                // dp[i]的硬幣數是否會優於換成當前coin的數量
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        // dp[amount] == amount + 1代表沒有任何DP走到結果
        return dp[amount] == amount + 1 ? -1 : dp[amount];

    }
}