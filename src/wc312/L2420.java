package wc312;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L2420 {
	public static void main(String[] args) {
		new L2420();
	}

	L2420() {
		goodIndices(new int[] { 2, 1, 1, 1, 3, 4, 1 }, 2);
	}

	public List<Integer> goodIndices(int[] a, int k) {
		int n = a.length;
		int[] dp1 = new int[n + 1];
		Arrays.fill(dp1, 1);
		int[] dp2 = new int[n + 1];
		Arrays.fill(dp2, 1);
		List<Integer> ans = new ArrayList<>();
		// 計算最大連續
		for (int i = 1; i < n; i++) {
			if (a[i - 1] >= a[i]) {
				dp1[i] = dp1[i - 1] + 1;
			}
		}

		for (int i = n - 2; i >= 0; i--) {
			if (a[i] <= a[i + 1]) {
				dp2[i] = dp2[i + 1] + 1;
			}
		}
		// 如果最大連續大於k則代表符合
		for (int i = k; i < n - k; i++) {
			if (dp1[i - 1] >= k && dp2[i + 1] >= k) {
				ans.add(i);
			}
		}

		return ans;
	}

}
