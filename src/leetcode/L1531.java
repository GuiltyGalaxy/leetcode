package leetcode;

import java.util.Arrays;

public class L1531 {
	public static void main(String[] args) {
		new L1531();
	}

	L1531() {
		getLengthOfOptimalCompression("aabaabbcbbbaccc", 6);
	}

	public int getLengthOfOptimalCompression(String s, int K) {
		// dp[i][k]: 到s[:i]所移除K數的最小長度
		int n = s.length();
		int[][] dp = new int[n + 1][K + 1];
		// 預設填充都為s長度
		for (int[] i : dp)
			Arrays.fill(i, n);

		dp[0][0] = 0;

		for (int i = 1; i <= n; i++) {
			for (int k = 0; k <= K; k++) {
				// k>0之後開始計算最小長度
				if (k > 0) {
					dp[i][k] = Math.min(dp[i][k], dp[i - 1][k - 1]);
				}

				int same = 0;
				int diff = 0;

				// 從後開始計算
				for (int j = i; j >= 1; j--) {
					if (s.charAt(j - 1) == s.charAt(i - 1)) {
						same++;
					} else {
						diff++;
					}

					// 差異大於可移除的情況下則不在做計算
					if (diff > k) {
						break;
					}
					// j - 1代表目前計算到的程度
					// k - diff代表已移除的清況
					dp[i][k] = Math.min(dp[i][k], dp[j - 1][k - diff] + getLen(same));
				}
			}
		}
		return dp[n][K];
	}

	// getLen取得移除該字母後可能到的長度
	private int getLen(int count) {
		if (count == 1)
			return 1;
		else if (count < 10)
			return 2;
		else if (count < 100)
			return 3;
		else
			return 4;
	}
}
