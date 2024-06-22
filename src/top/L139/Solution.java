package top.L139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> wordSet = new HashSet<>(wordDict);
        // 找最大單字長度
        int maxWordLength = 0;
        for (String word : wordDict) {
            maxWordLength = Math.max(maxWordLength, word.length());
        }

        // 記錄該字串是否可組合的dp
        boolean[] dp = new boolean[s.length() + 1];
        // 空字串一定可以
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= Math.max(0, i - maxWordLength); j--) {
                // 由於dp[j]代表s中前j個字是可被組合的，所以wordSet如果含s[j,i]代表dp[i]也是可組合
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        // 算到最後長度可符合代表該字可被字典組合
        return dp[s.length()];
    }
}