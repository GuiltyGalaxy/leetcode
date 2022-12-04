package contest.bc85;

public class L6156 {
	public static void main(String[] args) {
		new L6156();
	}

	L6156() {
		// shiftingLetters("abc", new int[][] { { 0, 1, 0 }, { 1, 2, 1 }, { 0, 2, 1 }
		// });
//		shiftingLetters("dztz", new int[][] { { 0, 0, 0 }, { 1, 1, 1 } });
//		shiftingLetters("xuwdbdqik", new int[][] { { 4, 8, 0 }, { 4, 4, 0 }, { 2, 4, 0 }, { 2, 4, 0 }, { 6, 7, 1 },
//				{ 2, 2, 1 }, { 0, 2, 1 }, { 8, 8, 0 }, { 1, 3, 1 } });
		shiftingLetters("ksztajnymer",
				new int[][] { { 4, 9, 1 }, { 2, 5, 1 }, { 7, 9, 0 }, { 6, 10, 0 }, { 1, 7, 1 }, { 0, 7, 1 },
						{ 0, 3, 0 }, { 3, 3, 1 }, { 7, 9, 0 }, { 7, 7, 0 }, { 6, 7, 0 }, { 7, 9, 0 }, { 3, 9, 0 },
						{ 10, 10, 1 }, { 8, 9, 0 }, { 6, 9, 1 }, { 1, 2, 1 }, { 3, 9, 0 }, { 8, 10, 1 }, { 4, 7, 1 },
						{ 9, 10, 1 }, { 8, 9, 0 }, { 5, 8, 0 }, { 8, 9, 1 }, { 0, 7, 1 }, { 2, 2, 1 }, { 8, 8, 1 },
						{ 3, 7, 0 }, { 1, 10, 1 }, { 9, 9, 1 }, { 4, 9, 0 }, { 5, 6, 1 }, { 7, 8, 1 }, { 8, 9, 0 },
						{ 7, 7, 1 }, { 9, 9, 1 } });
	}

	public String shiftingLetters(String s, int[][] shifts) {
		char[] cs = s.toCharArray();
		int[] change = new int[s.length() + 1];
		for (int[] cmd : shifts) {
			int start = cmd[0];
			int end = cmd[1];
			int fw = cmd[2];
			change[start] += fw == 1 ? 1 : -1;
			change[end + 1] -= fw == 1 ? 1 : -1;
		}

		int tmp = 0;
		int idx = 0;
		for (int i = 0; i < s.length(); i++) {
			tmp += change[i];
			while (tmp < 0)
				tmp += 26;
			int ch = (cs[idx] - 'a' + tmp) % 26;
			cs[idx] = (char) ('a' + ch);
			idx++;
		}
		return String.valueOf(cs);
	}
}
