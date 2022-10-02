package leetcode;

public class L838 {
	public static void main(String[] args) {
		new L838();
	}

	L838() {

	}

	public String pushDominoes(String dominoes) {
		char[] a = dominoes.toCharArray();
		int L = -1;
		int R = -1;
		for (int i = 0; i <= dominoes.length(); i++)
			if (i == a.length || a[i] == 'R') {
				// R...R
				if (R > L) {
					while (R < i) {
						a[R++] = 'R';
					}
				}
				R = i;
			} else if (a[i] == 'L') {
				// L...L
				if (L > R || R == -1) {
					while (++L < i) {
						a[L] = 'L';
					}
				} else {
					// R...L
					L = i;
					for (int lo = R + 1, hi = L - 1; lo < hi;) {
						a[lo++] = 'R';
						a[hi--] = 'L';
					}
				}
			}
		return new String(a);
	}
}
