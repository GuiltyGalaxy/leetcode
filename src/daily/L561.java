package daily;

import java.util.Arrays;

public class L561 {
	public int arrayPairSum(int[] nums) {
		int ans = 0;
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i += 2) {
			ans += nums[i];
		}

		return ans;
	}
}
