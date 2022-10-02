package wc313;

import java.util.Arrays;

public class L6195 {
	public static void main(String[] args) {
		new L6195();
	}

	L6195() {
		deleteString("aaabaab");
	}

	public int deleteString(String s) {
		int n = s.length();
		// LCS概念
		// lcs[i][j]代表從i開始與j開始最大相同字串長度
		// "babab"於lcs[0][2]會為3
		// 因[0] = "bab" [2] = "bab"
		// "abcab"於lcs[0][3]會為2
		// 因[0] = "ab" [3] = "ab"
		int[][] lcs = new int[n + 1][n + 1];
		int[] dp = new int[n];
		// 每次的dp都要從1開始，因你不知前面是否有連續可消除的數目
		Arrays.fill(dp, 1);
		for (int i = n - 1; i >= 0; --i) {
			char si = s.charAt(i);
			for (int j = i + 1; j < n; ++j) {
				char sj = s.charAt(j);
				// 更新當前最大LCS長度
				if (si == sj) {
					lcs[i][j] = lcs[i + 1][j + 1] + 1;
				}
				// LCS長度>=當前距離則代表可以被消去
				if (lcs[i][j] >= j - i) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		return dp[0];
	}
}
