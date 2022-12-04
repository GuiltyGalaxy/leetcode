package contest.bc85;

public class L6158 {
	public static void main(String[] args) {
		new L6158();
	}

	L6158() {

	}

	public int minimumRecolors(String blocks, int k) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			sb.append("B");
		}
		if (blocks.contains(sb.toString())) {
			return 0;
		}
		int change = Integer.MAX_VALUE;
		char[] c = blocks.toCharArray();
		for (int i = 0; i <= c.length - k; i++) {
			int tmp = 0;
			for (int j = i; j < i + k; j++) {
				if (c[j] == 'W') {
					tmp++;
				}
			}
			change = Math.min(change, tmp);
		}
		return change;
	}
}
