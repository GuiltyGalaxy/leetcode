package contest.wc311;

public class L6183 {
	public static void main(String[] args) {
		new L6183();
	}

	L6183() {
		sumPrefixScores(new String[] { "dbhiwxxr", "hyqbpabh", "hyqlgnnxiy", "wosbckxrb", "wosbckxmfq" });
	}

	public int[] sumPrefixScores(String[] words) {
		int[] ans = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			int cnt = 0;
			String w = words[i];
			for (int k = 0; k < words.length; k++) {
				int match = match(words[k], w);
				cnt += match;
			}
			ans[i] = cnt;
		}
		return ans;
	}

	int match(String a, String b) {
		int cnt = 0;
		char[] as = a.toCharArray();
		char[] bs = b.toCharArray();
		int len = Math.min(as.length, bs.length);
		for (int i = 0; i < len; i++) {
			if (as[i] == bs[i]) {
				cnt++;
			} else {
				break;
			}
		}
		return cnt;
	}
}
