package leetcode;

import java.util.Arrays;

public class L1155 {
	public static void main(String[] args) {
		new L1155();
	}

	L1155() {
	}

	static final int MOD = 1000000007;

	public int numRollsToTarget(int n, int k, int target) {
		if (n * k < target || target < n)
			return 0;
		if (n == 1)
			return 1;

		int[] cache1 = new int[target + 1];
		int[] cache2 = new int[target + 1];
		int[] cacheT;
		Arrays.fill(cache1, 1, Math.min(k, target) + 1, 1);
		for (int i = 2; i <= n; i++) {
			int stop = Math.min(target, i + k - 1);
			int sum = 0;
			for (int j = i; j <= stop; j++) {
				cache2[j] = (sum = (sum + cache1[j - 1]) % MOD);
			}
			for (int j = stop, z = Math.min(target, i * k); j < z; j++) {
				sum = (sum - cache1[j - k] + cache1[j]) % MOD;
				cache2[j + 1] = sum < 0 ? sum + MOD : sum;
			}
			cacheT = cache1;
			cache1 = cache2;
			cache2 = cacheT;
		}
		return cache1[target];
	}
}



