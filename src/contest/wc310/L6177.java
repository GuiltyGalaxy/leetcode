package contest.wc310;

import java.util.HashSet;
import java.util.Set;

public class L6177 {
	public static void main(String[] args) {
		new L6177();
	}

	L6177() {

	}

	public int partitionString(String s) {
		int ans = 1;
		char[] ary = s.toCharArray();
		Set<Integer> set = new HashSet<>();
		for (char c : ary) {
			if (set.contains((int) c)) {
				set.clear();
				ans++;
			}
			set.add((int) c);
		}
		return ans;
	}
}
