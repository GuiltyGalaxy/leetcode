package top.L540;

class Solution {
    public int singleNonDuplicate(int[] nums) {

        int L = 0;
        int R = nums.length - 1;

        while (L < R) {
            int M = (L + R) / 2;
            boolean odd = M % 2 == 0 && nums[M] == nums[M + 1];
            boolean even = M % 2 == 1 && nums[M] == nums[M - 1];
            //條件達成代表缺的在左邊，往左靠
            if (odd || even) {
                L = M + 1;
            } else {
                R = M;
            }
        }
        return nums[L];
    }
}