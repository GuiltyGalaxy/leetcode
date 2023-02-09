package top.L977;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        //由於數組已排序，所以可以利用2 point解決
        int R = 0;
        int L = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            //比較絕對值較大者放入結果
            if (Math.abs(nums[R]) > Math.abs(nums[L])) {
                result[i] = nums[R] * nums[R];
                R++;
            } else {
                result[i] = nums[L] * nums[L];
                L--;
            }
        }
        return result;
    }
}