package contest.wc334.L2576;


import java.util.Arrays;

class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);
        int L = 0;
        //假設最大可能為全部配對成功
        //所以從mid開始去做配對
        int R = (n + 1) / 2;
        while (R < n) {
            //配對成功
            if (nums[L] * 2 <= nums[R]) {
                L++;
            }
            //沒成功R後移
            R++;
        }
        //最後L的index就是最後條件符合對數
        return 2 * L;
    }
}