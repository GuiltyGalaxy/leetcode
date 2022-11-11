package daily;

import java.util.Arrays;

public class L948 {
	public static void main(String[] args) {
		new L948();
	}

	L948() {
		bagOfTokensScore(new int[] { 55, 71, 82 }, 54);
	}

	public int bagOfTokensScore(int[] tokens, int power) {

		int start = 0;
		int end = tokens.length - 1;
		int ans = 0;
		int tmp = 0;
		Arrays.sort(tokens);
		while (start - end != 1) {
			if (power >= tokens[start]) {
				power -= tokens[start];
				tmp++;
				start++;
			} else {
				if (tmp > 0) {
					power += tokens[end];
					tmp--;
				}
				end--;
			}
			ans = Math.max(ans, tmp);
		}

		return ans;
	}
}
