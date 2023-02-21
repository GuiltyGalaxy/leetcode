package top.L153;

class Solution {
    public int findMin(int[] nums) {
        int L = 0;
        int R = nums.length - 1;
        int ans = 0;
        while (L <= R) {
            int M = (L + R) / 2;
            ans = nums[M];
            //有種情況是最小值剛好在中間，當相鄰兩數都比他大
            if (M > 0 && M < nums.length - 1 && nums[M] < nums[M - 1] && nums[M] < nums[M + 1]) {
                return ans;
            }
            //判定小區間在L還是R
            if (nums[M] >= nums[L] && nums[M] >= nums[R]) {
                L = M + 1;
            } else {
                R = M - 1;
            }
        }
        return ans;
    }
}