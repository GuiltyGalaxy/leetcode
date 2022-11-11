package daily;

import java.util.HashMap;
import java.util.Map;

public class L219 {
	public static void main(String[] args) {
		new L219();
	}

	L219() {
	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int val = nums[i];
			// 查看該數字是否有前一個紀錄位子
			Integer dst = map.get(val);
			if (dst != null) {
				// 將前一次與本次相比
				if (Math.abs(dst - i) <= k) {
					return true;
				}
			}
			// 紀錄最後位子
			map.put(val, i);
		}

		return false;
	}
}
