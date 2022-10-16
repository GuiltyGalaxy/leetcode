package wc315;

public class L6207 {
	public static void main(String[] args) {
		new L6207();
	}

	L6207() {
		countSubarrays(new int[] { 1, 3, 5, 2, 7, 5 }, 1, 5);
	}

	// O(N) sliding window
	public long countSubarrays(int[] nums, int minK, int maxK) {
		long ans = 0;
		// 最右邊數值index
		int i = 0;
		// 最左邊數值index
		int j = 0;
		// 最後一次最小數值index
		long jmin = -1;
		// 最後一次最大數值index
		long jmax = -1;
		// 最右邊數值index
		for (i = 0; i < nums.length; i++) {
			// 超出範圍
			// 更新j與重置jmin jmax
			if (nums[i] < minK || nums[i] > maxK) {
				jmin = jmax = -1;
				j = i + 1;
			}
			// 找到符合minK紀錄
			if (nums[i] == minK) {
				jmin = i;
			}
			// 找到符合maxK紀錄
			if (nums[i] == maxK) {
				jmax = i;
			}
			// 該輪可選的數量為Math.min(jmin, jmax) - j + 1
			// jmin與jmax只要其中一個是-1那絕對小於0
			// 代表目前window還不符合條件
			ans += Math.max(0L, Math.min(jmin, jmax) - j + 1);
		}
		return ans;
	}

	// TLE O(N^2)
	public long countSubarrays2(int[] nums, int minK, int maxK) {
		long ans = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= maxK && nums[i] >= minK) {
				boolean min = false;
				boolean max = false;
				for (int j = i; j < nums.length; j++) {
					if (nums[j] > maxK || nums[j] < minK) {
						break;
					}
					if (nums[j] == minK) {
						min = true;
					}
					if (nums[j] == maxK) {
						max = true;
					}
					if (min && max) {
						ans++;
						for (int k = j + 1; k < nums.length; k++) {
							if (nums[k] <= maxK && nums[k] >= minK) {
								ans++;
							} else {
								break;
							}
						}
						break;
					}
				}
			}
		}
		return ans;
	}
}
