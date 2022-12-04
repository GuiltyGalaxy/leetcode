package contest.wc315;

import java.util.HashSet;
import java.util.Set;

public class L6204 {
	public static void main(String[] args) {
		new L6204();
	}

	L6204() {
		
	}

    public int findMaxK(int[] nums) {
		Set<Integer> set = new HashSet<>();
		// 建立正向表
		for (int i : nums) {
			if (i > 0) {
				set.add(i);
			}
		}

		int ans = -1;
		// 從正向表中找有無對應負值
		for (int i : nums) {
			if (i < 0 && set.contains(-i)) {
				ans = Math.max(-i, ans);
			}
		}
		return ans;
    }
}
