package contest.bc86;

import java.util.PriorityQueue;

public class L2398 {
	public static void main(String[] args) {
		new L2398();
	}

	L2398() {
		maximumRobots(new int[] { 3, 6, 1, 3, 4 }, new int[] { 2, 25, 3, 4, 5 }, 25);
	}

	public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
		int ans = 0;
		// 預設先選一台機器人
		int j = -1;
		long s = 0;
		// 將充電最大的機器人設為最優先移除
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));
		for (int i = 0; i < runningCosts.length; i++) {
			s += runningCosts[i];
			// 加入新機器人
			pq.offer(new int[] { chargeTimes[i], i });
			// 超過預算的情況下移除最優先機器人
			while (s * (i - j) + removeStale(pq, j) > budget) {
				s -= runningCosts[++j];
			}
			ans = Math.max(ans, i - j);
		}
		return ans;
	}

	private int removeStale(PriorityQueue<int[]> pq, int j) {
		while (!pq.isEmpty() && pq.peek()[1] <= j) {
			pq.poll();
		}
		if (pq.isEmpty()) {
			return 0;
		}
		return pq.peek()[0];
	}
}
