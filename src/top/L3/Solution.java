package top.L3;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        //直接開到ascii size
        int[] cache = new int[256];
        for (int R = 0, L = 0; R < s.length(); R++) {
            //字母有在cache中則更新L，確保L到R之間都無重複字
            L = (cache[s.charAt(R)] > 0) ? Math.max(L, cache[s.charAt(R)]) : L;
            //紀錄字母位子
            cache[s.charAt(R)] = R + 1;
            result = Math.max(result, R - L + 1);
        }
        return result;
    }
}