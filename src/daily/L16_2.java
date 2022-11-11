package daily;

import java.util.Arrays;

public class L16_2 {

	// O(N^2) 部分條件優化
	public int threeSumClosest(int[] nums, int target) {

		Arrays.sort(nums);
		int size = nums.length;
		int result = 0;
		int closest = Integer.MAX_VALUE;

		for (int idx_1 = 0; idx_1 < nums.length - 2; idx_1++) {
			// 與前數相同數不處理
			if (idx_1 > 0 && nums[idx_1 - 1] == nums[idx_1]) {
				continue;
			}
			// nums[i] * 3 為最小和，如果這個數都大於target代表沒有其他可能性了
			if (nums[idx_1] * 3 >= target) {
				int sum = nums[idx_1] + nums[idx_1 + 1] + nums[idx_1 + 2];
				if (sum - target < closest) {
					result = sum;
				}
				break;
			}
			// 計算idx_1為準最大值，如果小於target則不用往下算了，直接進下個idx_1
			int sum = nums[idx_1] + nums[nums.length - 1] + nums[nums.length - 2];
			if (sum <= target) {
				if (target - sum < closest) {
					closest = target - sum;
					result = sum;
				}
				continue;
			}

			// 雙指針尋找所有可能
			int idx_2 = idx_1 + 1;
			int idx_3 = size - 1;
			while (idx_2 < idx_3) {
				int curSum = nums[idx_1] + nums[idx_2] + nums[idx_3];
				if (curSum == target) {
					return curSum;
				}
				if (Math.abs(target - curSum) < closest) {
					result = curSum;
					closest = Math.abs(target - curSum);
				}
				// 照目前curSum去決定要移動idx_2還idx_3
				if (curSum < target) {
					++idx_2;
				} else {
					--idx_3;
				}
			}
		}

		return result;
	}
}
