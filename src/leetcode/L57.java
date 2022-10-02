package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L57 {
	public static void main(String[] args) {
		new L57();
	}

	L57() {
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {

		if (intervals.length == 0) {
			return new int[][] { { newInterval[0], newInterval[1] } };
		}

		int maxI = newInterval[1];
		int minI = newInterval[0];
		for (int[] i : intervals) {
			if (i[1] > maxI)
				maxI = i[1];
			if (i[0] < minI)
				minI = i[0];
		}
		int[] starts = new int[maxI + 1];
		int[] stops = new int[maxI + 1];

		for (int[] i : intervals) {
			starts[i[0]]++;
			stops[i[1]]++;
		}

		starts[newInterval[0]]++;
		stops[newInterval[1]]++;

		List<int[]> result = new ArrayList<>();
		int n = 0;
		int start = 0;
		for (int i = minI; i <= maxI; i++) {
			if (starts[i] != 0) {
				if (n == 0) {
					start = i;
				}
				n += starts[i];
			}
			if (stops[i] != 0) {
				if ((n -= stops[i]) == 0)
					result.add(new int[] { start, i });
			}
		}

		return result.toArray(new int[0][0]);
	}
}
