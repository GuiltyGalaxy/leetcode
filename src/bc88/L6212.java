package bc88;

public class L6212 {
	public static void main(String[] args) {
		new L6212();
	}

	L6212() {
		equalFrequency("ddaccb");
	}

	public boolean equalFrequency(String word) {
		final int N = word.length();

		for (int i = 0; i < N; ++i) {
			String s = word.substring(0, i) + word.substring(i + 1);
			if (freqEqual(s)) {
				return true;
			}
		}
		return false;
	}

	private static boolean freqEqual(String s) {
		int[] freq = new int[128];
		for (char c : s.toCharArray()) {
			++freq[c];
		}

		int target = -1;
		for (char c = 'a'; c <= 'z'; ++c) {
			if (freq[c] == 0) {
				continue;
			}

			if (target < 0) {
				target = freq[c];
			}
			if (freq[c] != target) {
				return false;
			}
		}
		return true;
	}

}
