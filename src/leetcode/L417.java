package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L417 {
	public static void main(String[] args) {
		new L417();
	}

	L417() {
	}

	int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	int n = 0;
	int m = 0;

	public List<List<Integer>> pacificAtlantic(int[][] matrix) {
		List<List<Integer>> res = new LinkedList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		n = matrix.length;
		m = matrix[0].length;
		// One visited map for each ocean
		boolean[][] pacific = new boolean[n][m];
		boolean[][] atlantic = new boolean[n][m];
		Queue<int[]> pQueue = new LinkedList<>();
		Queue<int[]> aQueue = new LinkedList<>();
		// Vertical border
		for (int i = 0; i < n; i++) {
			pQueue.offer(new int[] { i, 0 });
			aQueue.offer(new int[] { i, m - 1 });
			pacific[i][0] = true;
			atlantic[i][m - 1] = true;
		}
		// Horizontal border
		for (int i = 0; i < m; i++) {
			pQueue.offer(new int[] { 0, i });
			aQueue.offer(new int[] { n - 1, i });
			pacific[0][i] = true;
			atlantic[n - 1][i] = true;
		}
		bfs(matrix, pQueue, pacific);
		bfs(matrix, aQueue, atlantic);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (pacific[i][j] && atlantic[i][j]) {
					List<Integer> tmp = new LinkedList<>();
					tmp.add(i);
					tmp.add(j);
					res.add(tmp);
				}
			}
		}
		return res;
	}

	public void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int[] d : dir) {
				int x = cur[0] + d[0];
				int y = cur[1] + d[1];
				// over range
				if (x < 0 || x >= n) {
					continue;
				}
				if (y < 0 || y >= m) {
					continue;
				}
				// is visited
				if (visited[x][y]) {
					continue;
				}
				// 該點高度比原點還低則跳過
				if (matrix[x][y] < matrix[cur[0]][cur[1]]) {
					continue;
				}

				visited[x][y] = true;
				queue.offer(new int[] { x, y });
			}
		}
	}
}
