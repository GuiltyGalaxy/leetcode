package leetcode;

public class L1832 {
	public static void main(String[] args) {
		new L1832();
	}

	L1832() {
	}

	public boolean checkIfPangram(String sentence) {
		int[] map = new int[26];
		for (char c : sentence.toCharArray()) {
			map[c - 'a']++;
		}

		for (int i : map) {
			if (i == 0) {
				return false;
			}
		}
		return true;
	}
}
