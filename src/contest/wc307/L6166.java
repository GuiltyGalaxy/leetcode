package contest.wc307;

public class L6166 {
	public String largestPalindromic(String num) {
		StringBuilder sb = new StringBuilder();
		int[] cnt = new int[10];
		for (char c : num.toCharArray()) {
			cnt[c - '0']++;
		}
		boolean frist = true;
		int max_mid = -1;
		for (int i = 9; i >= 0; i--) {
			int tmp = cnt[i] / 2;
			if (cnt[i] % 2 == 1) {
				max_mid = Math.max(max_mid, i);
			}
			if (tmp > 0) {
				if (frist && i == 0) {
					continue;
				}
				frist = false;
				char c = (char) (i + '0');
				for (int j = 0; j < tmp; j++) {
					sb.append(c);
				}
			}
		}
		String rev = sb.reverse().toString();
		sb.reverse();
		if (max_mid >= 0) {
			char c = (char) (max_mid + '0');
			sb.append(c);
		}

		if (sb.length() == 0) {
			return "0";
		}

		return sb.toString() + rev;
	}

}
