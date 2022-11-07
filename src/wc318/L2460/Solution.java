package wc318.L2460;

class Solution {
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            //與後相等且不為0
            if (nums[i] == nums[i + 1] && nums[i] != 0) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
        }
        //將0都移至後面
        nums = moveZeroToOffer(nums);

        return nums;
    }

    public int[] moveZeroToOffer(int[] in) {
        int[] ret = new int[in.length];
        int idx = 0;
        for (int i : in) {
            if (i != 0) {
                ret[idx++] = i;
            }
        }
        return ret;
    }
}