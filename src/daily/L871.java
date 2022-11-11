package daily;

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
		// PriorityQueue�|�̾ڱ���w��queue����m
		Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
		int i = 0;
		int n = stations.length;
		int stops = 0;
		int maxDistance = startFuel;
		while (maxDistance < target) {
			while (i < n && stations[i][0] <= maxDistance) {
				// �N�̤j�Z�������[�o��������iqueue
				queue.offer(stations[i++][1]);
			}
			if (queue.isEmpty())
				return -1;
			// ���̰��[�o
			maxDistance += queue.poll();
			stops++;
		}
		return stops;
	}
}
