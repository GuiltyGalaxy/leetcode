package top.L1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        int index = 0;
        for (int num : nums) {
            if (map.containsKey(target - num)) {
                ans[0] = map.get(target - num);
                ans[1] = index;
                return ans;
            }
            map.put(num, index++);
        }
        return ans;
    }
}