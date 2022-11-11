package daily;

public class L1578 {
	public static void main(String[] args) {
		new L1578();
	}

	L1578() {
		minCost("aaaaa", new int[] { 1, 2, 1, 2, 1 });
	}

	// O(N) S(1)
	public int minCost(String colors, int[] neededTime) {
		int ret = 0;
		int max_cost = 0;
		int sum_cost = 0;
		for (int i = 0; i < colors.length(); i++) {
			// 不連續的情況下紀錄先前連續的移除結果
			if (i > 0 && colors.charAt(i) != colors.charAt(i - 1)) {
				// sum_cost-max_cost會是這連續中花費最短時間
				ret += sum_cost - max_cost;
				sum_cost = 0;
				max_cost = 0;
			}
			// 計算全部移除的時間
			sum_cost += neededTime[i];
			// 在連續的情況下只能留一個
			// 一定是留下最花時間的
			max_cost = Math.max(max_cost, neededTime[i]);
		}
		ret += sum_cost - max_cost;
		return ret;
	}
}
