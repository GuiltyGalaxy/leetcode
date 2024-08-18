package contest.wc411.L3259;


class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {

        int n = energyDrinkA.length;
        // 利用dp去存選A[0] or B[1]的可能結果
        // n+1是為了計算方便做一個假結尾
        // 這樣一開始的i+1才不會超出範圍
        long[][] dp = new long[n + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            // 當前的值會是我改喝另一邊的情況與繼續喝當前的情況比較大小
            dp[i][0] = Math.max(energyDrinkA[i] + dp[i + 1][0], dp[i + 1][1]);
            dp[i][1] = Math.max(energyDrinkB[i] + dp[i + 1][1], dp[i + 1][0]);
        }


        return Math.max(dp[0][0], dp[0][1]);
    }
}