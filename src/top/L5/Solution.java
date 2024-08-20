package top.L5;

public class Solution {

    private final int LEFT = -1;
    private final int MID = 0;
    private final int RIGHT = 1;
    private int begin, maxLen;

    public String longestPalindrome(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        // 從中間開始找
        expandCenter(str, n / 2, MID);
        return new String(str, begin, maxLen);
    }

    private void expandCenter(char[] str, int idx, int direction) {
        int len = str.length;
        int i = idx - 1;
        int j = idx + 1;

        // 撇除掉起始相同的字
        // 這動作是為了避免偶數的情況 "abba"
        // ex. "naaaaaan"
        //      ^   ^  ^
        //      |   |  |
        //      i  idx j
        while (i >= 0 && str[i] == str[idx]) i--;
        while (j < len && str[j] == str[idx]) j++;

        // 計算最大回文長度
        int left = i;
        int right = j;
        while (left >= 0 && right < len && str[left] == str[right]) {
            left--;
            right++;
        }

        // 如果比當前最大回文大則記錄
        if (right - left - 1 > maxLen) {
            begin = left + 1;
            maxLen = right - left - 1;
        }

        // 剩下的長度如果比目前maxLen大
        // 代表還有更長的可能，所以繼續找
        if (((i + 1) * 2) > maxLen && direction <= MID) {
            expandCenter(str, i, LEFT);
        }

        if (((len - j) * 2) > maxLen && direction >= MID) {
            expandCenter(str, j, RIGHT);
        }
    }

    /**
     * DP解法
     */
    public String longestPalindrome2(String s) {

        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        int start = 0;
        int end = 0;
        // 如果i到j有palindrome，則dp[i][j] = true
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); ++i) {
            dp[i][i] = true;
            for (int j = 0; j < i; ++j) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    // 更新最大長度
                    if (i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }

    /**
     * Manacher's解法 O(n)
     */
    public String longestPalindrome3(String s) {
        // 插入補助符號 abcd => $#a#b#c#d#@
        StringBuilder t = new StringBuilder("$#");
        for (int i = 0; i < s.length(); i++) {
            t.append(s.charAt(i));
            t.append('#');
        }
        t.append('@');

        int[] p = new int[t.length()];
        // 最左邊回文起始中心位子
        int paliLeftRange = 0;
        // 最右邊回文起始中心位子
        int paliRightRange = 0;
        int end = 0;
        int start = 0;
        for (int i = 1; i < t.length() - 1; i++) {

            // i如果再右邊界中
            // 則去計算p[2 * paliLeftRange - i], paliRightRange - i哪個比較小當作起始值
            p[i] = paliRightRange > i ? Math.min(p[2 * paliLeftRange - i], paliRightRange - i) : 1;

            // 計算以i為中心有多長的Palindrome
            while (t.charAt(i + p[i]) == t.charAt(i - p[i])) {
                p[i]++;
            }

            // i + p[i]為最右邊對稱回文起始點
            // 最大回文長度有異動更新邊界
            if (paliRightRange < i + p[i]) {
                paliRightRange = i + p[i];
                paliLeftRange = i;
            }

            if (start < p[i]) {
                start = p[i];
                end = i;
            }
        }
        return s.substring((end - start) / 2, (end - start) / 2 + start - 1);
    }
}
