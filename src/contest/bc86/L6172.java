package contest.bc86;

public class L6172 {
	public static void main(String[] args) {
		new L6172();
	}

	L6172() {
		isStrictlyPalindromic(9);
	}

	public boolean isStrictlyPalindromic(int n) {
		for (int b = 2; b <= n - 2; b++) {
			String s = "";
			int tmp = n;
			while (tmp != 0) {
				int c = tmp % b;
				s = c + s;
				tmp /= b;
			}
			if (!checkPalindromic(s)) {
				return false;
			}
		}
		return true;
	}

	public boolean checkPalindromic(String s) {
		StringBuilder sb = new StringBuilder(s).reverse();
		return s.equals(sb.toString());
	}
}
