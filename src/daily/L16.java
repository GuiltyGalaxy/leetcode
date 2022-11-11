package daily;

import java.util.Arrays;

public class L16 {

	// O(N^2)
	public int threeSumClosest(int[] nums, int target) {

		Arrays.sort(nums);
		int size = nums.length;
		int closest = nums[0] + nums[1] + nums[2];

		for (int idx_1 = 0; idx_1 < size - 2; idx_1++) {
			// 與前一數相同不做計算
			if (idx_1 > 0 && nums[idx_1] == nums[idx_1 - 1]) {
				continue;
			}
			// 以固定idx_1的方式去foreach idx_2 idx_3
			int idx_2 = idx_1 + 1;
			int idx_3 = size - 1;
			while (idx_2 < idx_3) {
				int curSum = nums[idx_1] + nums[idx_2] + nums[idx_3];
				if (curSum == target) {
					return curSum;
				}
				if (Math.abs(target - curSum) < Math.abs(target - closest)) {
					closest = curSum;
				}
				// 照目前curSum去決定要移動idx_2還idx_3
				if (curSum < target) {
					++idx_2;
				} else {
					--idx_3;
				}
			}
		}
		return closest;
	}
}
