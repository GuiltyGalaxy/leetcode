package top.L15;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        int n = nums.length;
        //固定一數
        for (int i = 0; i < n - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = n - 1;
            //設定目標
            int target = -nums[i];
            while (L < R) {
                if (nums[L] + nums[R] == target) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    //排除連續
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                    continue;
                }
                if (nums[L] + nums[R] > target) {
                    R--;
                    continue;
                }
                if (nums[L] + nums[R] < target) {
                    L++;
                    continue;
                }
            }

        }
        return ans;
    }
}