package contest.bc137.L3255;


import java.util.Arrays;

class Solution {
    /**
     * 該題與3254一樣，只是複雜度提升
     */
    public int[] resultsArray(int[] nums, int k) {
        // 特殊情況處理
        if (nums.length == 1 || k == 1) {
            return nums;
        }
        int L = 0;
        int R = 1;
        // 預設全部為-1
        int[] ans = new int[nums.length - k + 1];
        Arrays.fill(ans, -1);
        while (R < nums.length) {
            // 當L條件不符合時，縮減到R-1
            while (L < R - 1 && nums[L + 1] - nums[L] != 1) {
                L++;
            }

            // 超度過長
            if (R - L + 1 > k) {
                L++;
            }

            // 不符合條件時代表中間都不會符合
            // 所以直接重置L
            if (nums[R] - nums[R - 1] != 1) {
                L = R;
                R++;
                continue;
            }
            // 到這邊代表window內的元素符合遞增
            // 由於是遞增R一定是最大
            // 長度符合就把R的值帶入
            if (R - L + 1 == k) {
                ans[L] = nums[R];
            }
            R++;
        }
        return ans;
    }
}