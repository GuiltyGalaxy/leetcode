package top.L1004;

class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int cnt = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                cnt++;
            }
            //window不符合條件時將start右移至window條件符合
            while (cnt > k) {
                if (nums[start] == 0) {
                    cnt--;
                }
                start++;
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}