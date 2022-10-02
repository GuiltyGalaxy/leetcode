package wc310;

import java.util.Arrays;
import java.util.PriorityQueue;

public class L2406 {
	public static void main(String[] args) {
		new L2406();
	}

	L2406() {
		minGroups(new int[][] { { 5, 10 }, { 6, 8 }, { 1, 5 }, { 2, 3 }, { 1, 10 } });
	}

	public int minGroups(int[][] intervals) {
		// 此題用會議室占用的思維想，[0]起始時間與[1]結束時間
		// 計算最大需使用幾個會議室可以讓所有人不衝突開到會
		// 案起始時間排序
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		// 優先柱列最前面為結束時間，因最快結束的一定可以先被給其他人用
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		for (int[] interval : intervals) {
			// 當有資料時，檢查是否有已結束之會議可使用，可以使用則剔除原先使用者
			if (!pq.isEmpty() && pq.peek()[1] < interval[0]) {
				pq.poll();
			}
			pq.add(interval);
		}
		return pq.size();
	}

}
