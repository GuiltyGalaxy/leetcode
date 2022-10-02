package wc313;

public class L6192 {
	public static void main(String[] args) {
		new L6192();
	}

	L6192() {
	}

	public int commonFactors(int a, int b) {
		int max = Math.max(a, b);
		int cnt = 0;
		for (int i = 1; i <= max; i++) {
			if (a % i == 0 && b % i == 0) {
				cnt++;
			}
		}
		return cnt;
	}
}
