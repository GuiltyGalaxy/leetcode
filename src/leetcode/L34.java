package leetcode;

public class L34 {
	public int[] searchRange(int[] nums, int target) {
		int[] ans = new int[] { nums.length, -1 };
		binarySearch(ans, nums, target, 0, nums.length - 1);
		if (ans[0] > ans[1]) {
			ans[0] = -1;
		}

		return ans;
	}

	public int binarySearch(int[] ans, int nums[], int target, int L, int R) {
		if (L <= R) {
			int M = L + (R - L) / 2;
			if (nums[M] == target) {
				// �V�k�G��
				if (ans[0] > M) {
					ans[0] = M;
					binarySearch(ans, nums, target, L, M - 1);
				}
				// �V���G��
				if (ans[1] < M) {
					ans[1] = M;
					binarySearch(ans, nums, target, M + 1, R);
				}
			}

			if (target > nums[M]) {
				binarySearch(ans, nums, target, M + 1, R);
			} else {
				binarySearch(ans, nums, target, L, M - 1);
			}
		}
		return -1;
	}
}
