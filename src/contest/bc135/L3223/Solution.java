package contest.bc135.L3223;


class Solution {
    public int minimumLength(String s) {
        // 先計算字母總數
        int[] cnt = new int[256];
        for (char c : s.toCharArray()) {
            cnt[c]++;
        }

        // 將每個字母移除到小於等於2
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 2) {
                cnt[i] %= 2;
                if (cnt[i] == 0) {
                    cnt[i] = 2;
                }
            }
        }

        // 計算剩下多少
        int ans = 0;
        for (int c : cnt) {
            ans += c;
        }
        return ans;
    }
}