package bc88;

import java.util.LinkedList;
import java.util.List;

public class L6213 {
	public static void main(String[] args) {
		new L6213();
	}

	L6213() {

	}

	public int xorAllNums(int[] nums1, int[] nums2) {
		List<Integer> list = new LinkedList<>();
		for (int n : nums1) {
			for (int n2 : nums2) {
				list.add(n ^ n2);
			}
		}
		int sum = 0;
		for (int i : list) {
			sum ^= i;
		}
		return sum;
	}
}
