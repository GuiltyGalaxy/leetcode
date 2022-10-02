package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class L871 {
	public static void main(String[] args) {
		new L871();
	}

	L871() {

	}

	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		if (startFuel >= target)
			return 0;
		// PriorityQueue會依據條件安插queue的位置
		Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
		int i = 0;
		int n = stations.length;
		int stops = 0;
		int maxDistance = startFuel;
		while (maxDistance < target) {
			while (i < n && stations[i][0] <= maxDistance) {
				// 將最大距離內的加油站全部放進queue
				queue.offer(stations[i++][1]);
			}
			if (queue.isEmpty())
				return -1;
			// 取最高加油
			maxDistance += queue.poll();
			stops++;
		}
		return stops;
	}
}
