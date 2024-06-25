package top.L169;

import java.util.Arrays;

class Solution {

    //排序解法
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int ans = nums[0];
        int max_cnt = 0;
        int cur_cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                cur_cnt++;
            } else {
                if (cur_cnt > max_cnt) {
                    ans = nums[i];
                    max_cnt = cur_cnt;
                }
                cur_cnt = 1;
            }
        }
        return ans;
    }

    //Moore Majority Vote Algorithm
    public int majorityElement1(int[] nums) {
        // 由於題目求的數一定會大於2/n
        // 所以可以知道該數出現的次數一定大於剩下的數
        // 假設nums[0]為答案
        int ans = nums[0];
        // 出現次數1
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cnt == 0) {
                // 當次數為0代表該數一定不會是解答
                cnt++;
                ans = nums[i];
            } else if (ans == nums[i]) {
                // 與當前答案相同的話次數+1
                cnt++;
            } else {
                cnt--;
            }
        }
        return ans;
    }
}