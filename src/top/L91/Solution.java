package top.L91;


public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            dp[i] = dp[i + 1];
            // 當運算超過兩位再來判定
            if (i < n - 1) {
                // 檢查是不是可替代雙位數英文，因雙位數可以替代成兩個"2 26" "22 6"
                boolean isDouble = s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7';
                if (isDouble) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

    public int numDecodings2(String s) {

        if (s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        // 都無資料只有一種
        dp[0] = 1;
        // 單一字符也只有一種
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            char oneDigit = s.charAt(i - 1);
            char twoDigit = s.charAt(i - 2);

            // 第一個字碼有效
            if (oneDigit >= '1' && oneDigit <= '9') {
                dp[i] += dp[i - 1];
            }

            // 第二個字碼有效
            if (twoDigit == '1' || (twoDigit == '2' && oneDigit <= '6')) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}