package top.L3;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        int max = 0;
        int L = 0;
        int R = 0;
        while (R < s.length()) {
            //字母有在cache中則更新L，確保L到R之間都無重複字
            if (map[s.charAt(R)] > 0) {
                L = Math.max(L, map[s.charAt(R)]);
            }
            //紀錄字母位子
            map[s.charAt(R)] = R + 1;
            max = Math.max(max, R - L + 1);
            R++;
        }
        return max;
    }
}