package leetcode;

public class L718_2 {
	public static void main(String[] args) {
		new L718_2();
	}

	/**
	 * DP解法，O(m*n)但比較好懂
	 */
	public int findLength(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null)
			return 0;
		int m = nums1.length;
		int n = nums2.length;
		int max = 0;
		// dp[i][j] is the length of longest common subarray
		// ending with nums[i] and nums[j]
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
					continue;
				}
				if (nums1[i - 1] == nums2[j - 1]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max;
	}
}
