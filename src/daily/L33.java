package daily;

public class L33 {
	public int search(int[] nums, int target) {
		return binarySearch(nums, target, 0, nums.length - 1);
	}

	public int binarySearch(int nums[], int target, int L, int R) {
		while (L <= R) {
			int M = L + (R - L) / 2;
			if (nums[M] == target) {
				return M;
			}

			if (nums[M] >= nums[L]) {
				if (target >= nums[L] && target <= nums[M]) {
					R = M - 1;
				} else {
					L = M + 1;
				}
			} else {
				if (target >= nums[M] && target <= nums[R]) {
					L = M + 1;
				} else {
					R = M - 1;
				}
			}
		}
		return -1;
	}
}
