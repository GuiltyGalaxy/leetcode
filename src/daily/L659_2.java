package daily;

import java.util.HashMap;
import java.util.Map;

public class L659_2 {

	public static void main(String[] args) {
		new L659_2();
	}

	L659_2() {
		isPossible(new int[] { 1, 2, 3, 3, 4, 5 });
	}

	public boolean isPossible(int[] nums) {
		Map<Integer, Integer> a1 = new HashMap<>();
		Map<Integer, Integer> a2 = new HashMap<>();
		Map<Integer, Integer> a3 = new HashMap<>();

		for (int i : nums) {
			if (a1.getOrDefault(i - 1, 0) > 0) {
				a1.merge(i - 1, -1, Integer::sum);
				a2.merge(i, 1, Integer::sum);
				continue;
			}
			if (a2.getOrDefault(i - 1, 0) > 0) {
				a2.merge(i - 1, -1, Integer::sum);
				a3.merge(i, 1, Integer::sum);
				continue;
			}
			if (a3.getOrDefault(i - 1, 0) > 0) {
				a3.merge(i - 1, -1, Integer::sum);
				a3.merge(i, 1, Integer::sum);
				continue;
			}
			a1.merge(i, 1, Integer::sum);
		}

		for (var s : a1.entrySet()) {
			if (s.getValue() > 0)
				return false;
		}

		for (var s : a2.entrySet()) {
			if (s.getValue() > 0)
				return false;
		}

		return true;
	}

}
