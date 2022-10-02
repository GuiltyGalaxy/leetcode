package leetcode;


public class L300 {

	public static void main(String[] args) {
//		int[] in = new int[]{10,9,2,5,3,7,101,18};
		int[] in = new int[] { 10, 11, 12, 1, 2, 3, 4 };
		lengthOfLIS(in);
	}

	public static int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int dp[] = new int[n];
		dp[0] = nums[0];
		int res = 1;
		for (int i = 1; i < n; i++) {
			int curt = nums[i];
			if (curt > dp[res - 1]) {
				dp[res] = nums[i];
				res++;
			} else {
				for (int j = 0; j < i; j++) {
					if (dp[j] >= curt) {
						dp[j] = curt;
						break;
					}
				}
			}
		}
		return res;
	}
}
