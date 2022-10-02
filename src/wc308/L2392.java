package wc308;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class L2392 {
	public static void main(String[] args) {
		new L2392();
	}

	L2392() {
		buildMatrix(3, new int[][] { { 1, 2 }, { 2, 3 } }, new int[][] { { 2, 1 }, { 3, 2 } });
	}

	public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
		int[][] assignments = new int[k][2];
		List<List<Integer>> rowGraph = new ArrayList<>();
		List<List<Integer>> colGraph = new ArrayList<>();
		int[] rowInDegree = new int[k];
		int[] colInDegree = new int[k];
		for (int i = 0; i < k; i++) {
			rowGraph.add(new ArrayList<>());
			colGraph.add(new ArrayList<>());
		}
		// 建立有向圖
		// 數值-1是為了要能對應array
		for (int[] rowCondition : rowConditions) {
			int u = rowCondition[0] - 1;
			int v = rowCondition[1] - 1;
			rowGraph.get(u).add(v);
			rowInDegree[v]++;
		}
		for (int[] colCondition : colConditions) {
			int u = colCondition[0] - 1;
			int v = colCondition[1] - 1;
			colGraph.get(u).add(v);
			colInDegree[v]++;
		}
		int rowNumber = 0;
		int colNumber = 0;
		Queue<Integer> queueRow = new ArrayDeque<>();
		Queue<Integer> queueCol = new ArrayDeque<>();
		// 起始點為0，跟有向圖未描述的終點
		for (int i = 0; i < k; i++) {
			if (colInDegree[i] == 0)
				queueCol.add(i);
			if (rowInDegree[i] == 0)
				queueRow.add(i);
		}
		boolean[] rowVisited = new boolean[k];
		boolean[] colVisited = new boolean[k];
		// 檢查有向圖是否為一個環
		while (!queueRow.isEmpty()) {
			int node = queueRow.remove();
			if (!rowVisited[node]) {
				rowVisited[node] = true;
				// 每visit過一個點後，優先權往後挪
				assignments[node][0] = rowNumber++;
				// 移除該點所有的連接點
				for (int child : rowGraph.get(node)) {
					rowInDegree[child]--;
					// 當依附該點的指標都移除代表該點也成為了一個終點
					if (rowInDegree[child] == 0) {
						queueRow.offer(child);
					}
				}
			}
		}
		while (!queueCol.isEmpty()) {
			int node = queueCol.remove();
			if (!colVisited[node]) {
				colVisited[node] = true;
				assignments[node][1] = colNumber++;
				for (int child : colGraph.get(node)) {
					colInDegree[child]--;
					if (colInDegree[child] == 0) {
						queueCol.offer(child);
					}
				}
			}
		}
		// 輸出結果
		int[][] answer = new int[k][k];
		for (int i = 0; i < k; i++) {
			// 有任一點沒visited代表該有向圖不是環
			if (!colVisited[i] || !rowVisited[i])
				return new int[][] {};
			answer[assignments[i][0]][assignments[i][1]] = i + 1;
		}
		return answer;
	}
}
