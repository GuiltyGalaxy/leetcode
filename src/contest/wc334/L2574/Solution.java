package contest.wc334.L2574;

class Solution {
    public int[] leftRigthDifference(int[] nums) {

        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] ans = new int[n];

        for (int i = 1; i < n; i++) {
            arr1[i] = arr1[i - 1] + nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            arr2[i] = arr2[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = Math.abs(arr1[i] - arr2[i]);
        }
        return ans;
    }
}