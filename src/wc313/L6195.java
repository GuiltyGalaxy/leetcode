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
		// LCS����
		// lcs[i][j]�N��qi�}�l�Pj�}�l�̤j�ۦP�r�����
		// "babab"��lcs[0][2]�|��3
		// �][0] = "bab" [2] = "bab"
		// "abcab"��lcs[0][3]�|��2
		// �][0] = "ab" [3] = "ab"
		int[][] lcs = new int[n + 1][n + 1];
		int[] dp = new int[n];
		// �C����dp���n�q1�}�l�A�]�A�����e���O�_���s��i�������ƥ�
		Arrays.fill(dp, 1);
		for (int i = n - 1; i >= 0; --i) {
			char si = s.charAt(i);
			for (int j = i + 1; j < n; ++j) {
				char sj = s.charAt(j);
				// ��s��e�̤jLCS����
				if (si == sj) {
					lcs[i][j] = lcs[i + 1][j + 1] + 1;
				}
				// LCS����>=��e�Z���h�N��i�H�Q���h
				if (lcs[i][j] >= j - i) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		return dp[0];
	}
}
