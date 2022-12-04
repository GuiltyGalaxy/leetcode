package daily.L2256;

class Solution {
    public int minimumAverageDifference(int[] nums) {

        //先計算加總
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        long min = Integer.MAX_VALUE;
        long leftSum = 0;
        long rightSum = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            //把總和區分成兩塊
            leftSum += nums[i];
            rightSum = sum - leftSum;
            //各別將兩區塊總和計算
            long cur = Math.abs(leftSum / (i + 1) - (nums.length - i == 1 ? 0 : rightSum / (nums.length - i - 1)));
            if (cur < min) {
                ans = i;
                min = cur;
            }
        }
        return ans;
    }
}