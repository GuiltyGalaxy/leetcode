package daily;

public class L1155 {
	public static void main(String[] args) {
		new L1155();
	}

	L1155() {
		numRollsToTarget(2, 6, 7);
	}

	static final int MOD = 1_000_000_007;

	// O(d*f*t)
	public int numRollsToTarget(int d, int f, int target) {
		int[][] dp = new int[d + 1][target + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= d; i++) {
			// 計算當前n可以達到target的數量
			for (int j = 0; j <= target; j++) {
				// 只需累加前f個即可
				for (int k = 1; k <= f; k++) {
					if (j >= k) {
						// 可達數量為上一個循環的結果
						dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
					} else {
						// 大於target就不再計算
						break;
					}
				}
			}
		}
		return dp[d][target];
	}
}
