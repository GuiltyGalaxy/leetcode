package daily;

import java.util.Arrays;

public class L976 {
	public static void main(String[] args) {
		new L976();
	}

	L976() {

	}

	public int largestPerimeter(int[] nums) {

		Arrays.sort(nums);
		// 從最大的邊開始算有沒有符合的條件
		for (int i = nums.length - 1; i > 1; i--) {
			// 三角形形成條件，最小兩邊相加>第三邊
			if (nums[i] < nums[i - 1] + nums[i - 2]) {
				return nums[i] + nums[i - 1] + nums[i - 2];
			}
		}
		return 0;
	}
}
