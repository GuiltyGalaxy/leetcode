package daily;

import java.util.ArrayList;
import java.util.List;

public class L56 {
	public static void main(String[] args) {
		new L56();
	}

	L56() {
	}

	public int[][] merge(int[][] intervals) {
		if (intervals.length == 1)
			return intervals;

		int maxI = intervals[0][1];
		int minI = intervals[0][0];
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
