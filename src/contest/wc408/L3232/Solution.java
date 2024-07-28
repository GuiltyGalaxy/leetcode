package contest.wc408.L3232;


class Solution {
    public boolean canAliceWin(int[] nums) {
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if (num / 10 > 0) {
                a += num;
            } else {
                b += num;
            }
        }
        // 只要雙位數與個位數加總不同Alice一定贏
        return a != b;
    }
}