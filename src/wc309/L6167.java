package wc309;

public class L6167 {
	public static void main(String[] args) {
		new L6167();
	}

	L6167() {
		checkDistances("abbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzza",
				new int[] { 49, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
	}

	public boolean checkDistances(String s, int[] distance) {
		int[] prv = new int[26];
		char[] cs = s.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			char tmp = cs[i];
			if (prv[tmp - 'a'] == 0) {
				prv[tmp - 'a'] = i + 1;
			} else {
				int dis = i - prv[tmp - 'a'];
				if (dis != distance[tmp - 'a']) {
					return false;
				}
				prv[tmp - 'a'] = i + 1;
			}

		}
		return true;
	}
}
