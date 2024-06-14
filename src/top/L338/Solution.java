package top.L338;

class Solution {

    /**
     * 公式為res[i] = res[i / 2] + i % 2
     * res[i / 2]
     * 當數字是以2倍來看時(也就是偶數)，總bit count不變
     * 比如 6(110) => 12(1100) 會發現只是在尾端補0
     * 但我們不會只遇到偶數，所以需要i % 2去補正1
     * 比如 6(110) => 13(1101)
     */
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i=1; i<=n; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

    /**
     * 同樣利用上述公式概念，但改用recursion
     */
    public int[] countBits2(int n) {
        final int[] dp = new int[n + 1];
        binaryBuild(dp, 1, 1);
        return dp;
    }

    private void binaryBuild(int[] dp, int index, int ones) {
        if (index >= dp.length) {
            return;
        }
        dp[index] = ones;
        // odd去計算ones不變
        binaryBuild(dp, index * 2, ones);
        // even去計算ones+1
        binaryBuild(dp, index * 2 + 1, ones + 1);
    }
}