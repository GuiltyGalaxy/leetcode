package leetcode;

import java.util.Arrays;

public class L188 {
	public static void main(String[] args) {
		new L188();
	}

	L188() {
		maxProfit(2, new int[] { 2, 3, 2, 5, 7, 15, 50 });
	}

	public int maxProfit(int k, int[] prices) {
		return DP(prices, k);
	}

	private int DP(int[] prices, int k) {
		int[] costs = new int[k + 1];
		int[] profits = new int[k + 1];
		Arrays.fill(costs, Integer.MAX_VALUE);

		for (int currentPrice : prices) {
			for (int i = 0; i < k; i++) {
				costs[i + 1] = Math.min(costs[i + 1], currentPrice - profits[i]);
				profits[i + 1] = Math.max(profits[i + 1], currentPrice - costs[i + 1]);
			}
		}

		return profits[k];
	}
}
