package bc86;

import java.util.HashSet;
import java.util.Set;

public class L6171 {
	public static void main(String[] args) {
		new L6171();
	}

	L6171() {
		findSubarrays(new int[] { 1, -4, 4 });
	}

	public boolean findSubarrays(int[] nums) {
		if (nums.length <= 2) {
			return false;
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			int cnt = 0;
			for (int j = i; j < nums.length; j++) {
				cnt++;
				sum += nums[j];
				if (cnt > 2) {
					break;
				} else if (set.contains(sum) && cnt > 1) {
					return true;
				} else if (cnt == 2) {
					set.add(sum);
				}
			}
		}
		return false;
	}

}
