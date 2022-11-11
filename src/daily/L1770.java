package daily;

public class L1770 {
	public static void main(String[] args) {
		new L1770();
	}

	L1770() {
		maximumScore(new int[] { -5, -3, -3, -2, 7, 1 }, new int[] { -10, -5, 3, 4, 6 });
	}

	public int maximumScore(int[] nums, int[] multipliers) {
		int n = nums.length;
		int m = multipliers.length;
		int[][] dp = new int[m + 1][m + 1];

		// 利用假設剩餘數目的可能性去全部計算
		// 先從最後開始拿元素
		for (int i = m - 1; i >= 0; i--) {
			int mult = multipliers[i];
			// 如果 m == n，那最後能選的數字一定剩一個，所以把n的所有可能都算一遍後
			// L和R的差距會從0變1，循序圖如下
			// m == n 從這邊開始 L[left] = R[left]
			// m-1 == n 從這邊開始 L[left] = R[left+1]
			// m-2 == n 從這邊開始 L[left] = R[left+2] ...
			for (int left = i; left >= 0; left--) {
				int right = n - 1 - (i - left);
				// 將當前計算的結果與上一次計算結果相加
				int sum_left = mult * nums[left] + dp[i + 1][left + 1];
				int sum_right = mult * nums[right] + dp[i + 1][left];
				// 取比較大的當作本次結果
				dp[i][left] = Math.max(sum_left, sum_right);
			}
		}

		// 算到最後的就是最大可能
		return dp[0][0];
	}

}
