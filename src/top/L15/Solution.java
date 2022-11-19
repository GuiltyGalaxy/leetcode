package top.L15;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        //固定一數
        for (int i = 0; i < nums.length - 2; i++) {
            //nums[i] != nums[i - 1]排除連續
            if (i == 0 || nums[i] != nums[i - 1]) {
                //指向最小數字
                int j = i + 1;
                //指向最大數字
                int k = nums.length - 1;
                int target = -nums[i];
                while (j < k) {
                    if (nums[j] + nums[k] == target) {
                        //符合目標加入結果
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        //排除連續
                        while (j < k && nums[j] == nums[j + 1]) j++;
                        while (j < k && nums[k] == nums[k - 1]) k--;
                        j++;
                        k--;
                    } else if (nums[j] + nums[k] < target) {
                        //比目標小
                        ++j;
                    } else {
                        //比目標大
                        --k;
                    }
                }
            }
        }
        return res;
    }
}