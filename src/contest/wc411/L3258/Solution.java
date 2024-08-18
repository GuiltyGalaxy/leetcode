package contest.wc411.L3258;


class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int ans = 0;
        char[] cs = s.toCharArray();
        // 把所有可能算一遍
        for (int i = 0; i < s.length(); i++) {
            int cnt0 = 0;
            int cnt1 = 0;
            for (int j = i; j < s.length(); j++) {
                if (cs[j] == '0') {
                    cnt0++;
                } else {
                    cnt1++;
                }
                // 只要超出條件就算下一個
                if (cnt0 > k && cnt1 > k) {
                    break;
                }
                ans++;
            }
        }
        return ans;
    }
}
