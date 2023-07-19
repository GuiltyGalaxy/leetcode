package top.L424;


class Solution {
    public int characterReplacement(String s, int k) {

        int len = s.length();
        int[] count = new int[256];
        int start = 0;
        int maxCount = 0;
        int maxLength = 0;

        for (int end = 0; end < len; end++) {
            int curLen = end - start + 1;
            //累加目前window內count
            count[s.charAt(end)]++;
            //maxCount用來記錄目前window中重複次數最多的字母
            maxCount = Math.max(maxCount, count[s.charAt(end)]);
            //如果window長度減去maxCount大於k，代表window目前不符合條件
            //推移start到符合條件為止
            while (curLen - maxCount > k) {
                count[s.charAt(start)]--;
                start++;
                curLen--;
            }
            //更新maxLength
            maxLength = Math.max(maxLength, curLen);
        }
        return maxLength;
    }
}