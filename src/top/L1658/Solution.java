package top.L1658;

class Solution {


    public int minOperations(int[] nums, int x) {

        //去掉頭尾的和可以形成x
        //這問題可以簡化成
        //sum(nums) = target + x => target = sum(nums) - x
        int target = -x;
        for (int i : nums) {
            target += i;
        }

        if (target == 0) {
            return nums.length;
        }

        //代表sum(nums)還小於x
        if (target < 0) {
            return -1;
        }

        //只要找中間的Longest即可
        //2 pointer問題
        int ans = -1;
        int sum = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum > target) {
                sum -= nums[start++];
            }
            if (sum == target) {
                ans = Math.max(ans, end - start + 1);
            }
        }
        return ans == -1 ? -1 : nums.length - ans;
    }

}