package contest.wc405.L3210;

class Solution {
    public String getEncryptedString(String s, int k) {
        int n = s.length();
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            // 計算偏移
            int shift = (i + k) % n;
            // 把當前字母取代成偏移後的
            ans[i] = s.charAt(shift);
        }
        return new String(ans);
    }
}