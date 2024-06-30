package contest.wc404.L3201;


class Solution {
    public int maximumLength(int[] nums) {
        // 由於最大連續的組合可能為
        // 00 11
        // 10 01
        // 用兩組數組來記錄
        // count[0] 00
        // count[1] 11
        // end[0] 10
        // end[1] 01
        int[] count = new int[2];
        int[] end = new int[2];
        for (int num : nums) {
            count[num % 2]++;
            end[num % 2] = Math.max(end[num % 2], end[1 - num % 2] + 1);
        }

        // 回傳最大可能即可
        return Math.max(Math.max(count[0], count[1]), Math.max(end[0], end[1]));
    }
}