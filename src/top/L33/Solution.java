package top.L33;

class Solution {
    public int search(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;
        while (L <= R) {

            int M = (R + L) / 2;

            if (nums[M] == target) {
                return M;
            }
            //判斷正向區間偏向哪裡
            if (nums[M] >= nums[L]) {
                //正向區間在L邊，所以target在區間內要向L靠
                if (target >= nums[L] && target <= nums[M]) {
                    R = M - 1;
                } else {
                    L = M + 1;
                }
            } else {
                //正向區間在R邊，所以target在區間內要向R靠
                if (target >= nums[M] && target <= nums[R]) {
                    L = M + 1;
                } else {
                    R = M - 1;
                }
            }
        }
        return -1;
    }
}