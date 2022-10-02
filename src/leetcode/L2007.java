package leetcode;

import java.util.LinkedList;
import java.util.List;

public class L2007 {
	public static void main(String[] args) {
		new L2007();
	}

	L2007() {
		findOriginalArray(new int[] { 6, 3, 0, 1 });
	}

	public int[] findOriginalArray(int[] changed) {

		if (changed.length % 2 != 0) {
			return new int[0];
		}

		int max = Integer.MIN_VALUE;

		for (int num : changed) {
			max = Math.max(max, num);
		}

		if (max % 2 != 0) {
			return new int[0];
		}

		int[] ar = new int[max + 1];
		List<Integer> list = new LinkedList<>();
		for (int i : changed) {
			ar[i]++;
		}

		// 零特別處理
		if (ar[0] != 0) {
			if (ar[0] % 2 != 0) {
				return new int[0];
			}
			int j = ar[0] / 2;
			for (int i = 0; i < j; i++) {
				list.add(0);
			}
		}

		for (int i = 1; i < ar.length; ) {

			if (ar[i] == 0) {
				i++;
				continue;
			}

			if (2 * i > max || ar[i] > ar[2 * i]) {
				return new int[0];
			}

			ar[i * 2]--;
			ar[i]--;
			list.add(i);
		}

		return list.stream().mapToInt(i -> i).toArray();
	}
}
