package top.L454;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        // a+b+c+d = 0 => a+b = -(c+d)
        //所以把a+b的結果弄成map
        //之後去比對-(c+d)
        //有mapping到就代表有組合可以 = 0
        Map<Integer, Integer> map = new HashMap<>();

        for (int n1 : nums1) {
            for (int n2 : nums2) {
                map.put(n1 + n2, map.getOrDefault(n1 + n2, 0) + 1);
            }
        }

        int ans = 0;
        for (int n3 : nums3) {
            for (int n4 : nums4) {
                ans += map.getOrDefault(-(n3 + n4), 0);
            }
        }
        return ans;
    }
}