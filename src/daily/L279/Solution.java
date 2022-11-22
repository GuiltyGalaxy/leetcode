package daily.L279;

import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        //dp[n] = num
        //dp[0] = 0
        //dp[1] = dp[0]+1 = 1
        //dp[2] = dp[1]+1 = 2
        //dp[3] = dp[2]+1 = 3
        //dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 }
        //      = Min{ dp[3]+1, dp[0]+1 }
        //      = 1
        //dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 }
        //      = Min{ dp[4]+1, dp[1]+1 }
        //      = 2
        //dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; i - j * j >= 0; j++) {
                min = Math.min(min, dp[i - j * j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}