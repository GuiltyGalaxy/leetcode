package top.L409;

class Solution {
    public int longestPalindrome(String s) {
        int[] cnt = new int[256];
        for (char c : s.toCharArray()) {
            cnt[c]++;
        }

        int ans = 0;
        //有出現單一的則可以補在中間
        int tmp = 0;
        for (int i : cnt) {
            ans += (i / 2) * 2;
            if (tmp == 0) {
                tmp = i % 2;
            }
        }

        return ans + tmp;
    }
}