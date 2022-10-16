package wc315;

import java.util.HashSet;
import java.util.Set;

public class L6205 {
	public static void main(String[] args) {
		new L6205();
	}

	L6205() {
		countDistinctIntegers(new int[] { 1, 13, 10, 12, 31 });
	}

	public int countDistinctIntegers(int[] nums) {

		int[] tmp = new int[nums.length*2];
		for (int i = 0; i < nums.length; i++) {
			tmp[i] = nums[i];
		}
		// 建立後面數字反轉值
		for (int i = nums.length; i < tmp.length; i++) {
			StringBuilder sb = new StringBuilder(String.valueOf(nums[i - nums.length]));
			sb.reverse();
			tmp[i] = Integer.valueOf(sb.toString());
		}
		// 用set去計算共出現幾種數字
		Set<Integer> set = new HashSet<>();
		for (int i : tmp) {
			set.add(i);
		}
		return set.size();
    }
}
