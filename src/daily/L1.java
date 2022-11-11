package daily;

import java.util.HashMap;
import java.util.Map;

public class L1 {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] ans = new int[2];
		int idx = 0;
		for (int i : nums) {
			if (map.containsKey(target - i)) {
				int prv = map.get(target - i);
				ans[0] = prv;
				ans[1] = idx;
				break;
			}
			map.put(i, idx);
			idx++;
		}
		return ans;
	}


}
