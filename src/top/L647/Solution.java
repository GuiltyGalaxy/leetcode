package top.L647;

class Solution {

    private int ans = 0;

    public int countSubstrings(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        // 只要把以i為出發點的字母都找過一遍即可
        for (int i = 0; i < n; i++) {
            // odd情況
            isPalindrome(str, i, i, n);
            // even情況
            isPalindrome(str, i, i + 1, n);
        }
        return ans;
    }

    private void isPalindrome(char[] s, int i, int j, int n) {
        while (i >= 0 && j < n && s[i] == s[j]) {
            ans++;
            i--;
            j++;
        }
    }
}