package top.L153;

class Solution {
    public int findMin(int[] nums) {
        int L = 0;
        int R = nums.length - 1;
        int ans = 0;
        while (L <= R) {
            int M = (L + R) / 2;
            ans = nums[M];
            // 當M還在範圍內時
            // 只要他比左右兩邊都小，則代表該數為最小數
            boolean inRange = M > 0 && M < nums.length - 1;
            if (inRange && nums[M - 1] > nums[M] && nums[M] < nums[M + 1]) {
                return ans;
            }
            // 判定小區間在L還是R，往小數區間靠攏
            if (nums[M] >= nums[L] && nums[M] >= nums[R]) {
                L = M + 1;
            } else {
                R = M - 1;
            }
        }
        return ans;
    }
}