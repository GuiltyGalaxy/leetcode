package top.L18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        //選定一數i
        for (int i = 0; i < n - 3; i++) {
            //連續相同則跳過
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            //把最大的3數都相加也不超過target就找下個i
            if ((long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) {
                continue;
            }
            //最小的3個數相加就大於target則後面一定就沒有可能，直接跳出
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }

            //這邊就為3sum問題
            for (int j = i + 1; j < n - 2; j++) {

                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //這兩行道理同上
                if ((long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) continue;
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;

                int curTarget = target - nums[i] - nums[j];
                int low = j + 1;
                int hi = n - 1;
                while (low < hi) {
                    int curSum = nums[low] + nums[hi];
                    if (curSum == curTarget) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[low]);
                        temp.add(nums[hi]);
                        ans.add(temp);
                        //找下個low hi
                        low++;
                        hi--;
                        while (low < hi && nums[low] == nums[low - 1]) low++;
                        while (low < hi && nums[hi] == nums[hi + 1]) hi--;
                    } else if (curSum < curTarget) {
                        low++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return ans;
    }
}