package daily;

import java.util.HashMap;
import java.util.PriorityQueue;

public class L1329 {
	public static void main(String[] args) {
		new L1329();
	}

	L1329() {
		diagonalSort(new int[][] { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } });
	}

	public int[][] diagonalSort(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		HashMap<Integer, PriorityQueue<Integer>> d = new HashMap<>();
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				d.putIfAbsent(i - j, new PriorityQueue<>());
				d.get(i - j).add(mat[i][j]);
			}
		}
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				mat[i][j] = d.get(i - j).poll();
		return mat;
	}
}
