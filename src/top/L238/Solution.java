package top.L238;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ret = new int[len];
        ret[0] = 1;
        //計算左邊乘積
        for (int i = 1; i < len; i++) {
            ret[i] = ret[i - 1] * nums[i - 1];
        }
        int right = 1;
        //把右邊乘積也乘上
        for (int i = len - 1; i >= 0; i--) {
            ret[i] *= right;
            right *= nums[i];
        }
        return ret;
    }
}