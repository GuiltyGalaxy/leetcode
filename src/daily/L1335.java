package daily;

public class L1335 {
	public static void main(String[] args) {
		new L1335();
	}

	L1335() {

	}

	public int minDifficulty(int[] jobDifficulty, int d) {

		int len = jobDifficulty.length;
		if (len < d) {
			return -1;
		}

		// d = 可分配天數
		// len = 總工作數
		int[][] dp = new int[d][len];

		// 初始化0天都設定為最大可能的jobDifficulty[i]
		dp[0][0] = jobDifficulty[0];
		for (int i = 1; i < len; ++i) {
			dp[0][i] = Math.max(jobDifficulty[i], dp[0][i - 1]);
		}

		// 從第1D開始算
		for (int i = 1; i < d; i++) {
			for (int j = i; j < len; j++) {
				// 一定要先選定一個job
				int localMax = jobDifficulty[j];
				dp[i][j] = Integer.MAX_VALUE;
				// 計算所有可能性
				for (int schedule = j; schedule >= i; schedule--) {
					localMax = Math.max(localMax, jobDifficulty[schedule]);
					// i - 1 前一天
					// schedule - 1 該schedule分配的結果
					// localMax加上如果選的是這個job的情況
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][schedule - 1] + localMax);
				}
			}
		}

		return dp[d - 1][len - 1];
	}
}
