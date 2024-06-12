package top.L268;

import java.util.Arrays;

class Solution {
    /**
     * XOR
     */
    public int missingNumber1(int[] nums) {
        int res = nums.length;
        // 拆兩個部份看
        // A=res與所有nums XOR得到nums的XOR特徵
        // B=res從0到i XOR得到完整的集合XOR特徵
        // 當A^B就會得到這兩個的差值特徵，也就是缺少的那個數
        for (int i = 0; i < nums.length; i++) {
            // 為了速度所以同個for直接一起XOR
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }

    /**
     * Sum
     */
    public int missingNumber2(int[] nums) {
        int len = nums.length;
        // 由於為1的等差數列，所以可以使用(n*n+1)/2的公式求合
        int sum = len * (len + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    /**
     * Binary Search
     */
    public int missingNumber3(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > mid) {
                // 代表右半邊都是沒有缺少的
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}