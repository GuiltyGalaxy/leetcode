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
		// �إߦ��V��
		// �ƭ�-1�O���F�n�����array
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
		// �_�l�I��0�A�򦳦V�ϥ��y�z�����I
		for (int i = 0; i < k; i++) {
			if (colInDegree[i] == 0)
				queueCol.add(i);
			if (rowInDegree[i] == 0)
				queueRow.add(i);
		}
		boolean[] rowVisited = new boolean[k];
		boolean[] colVisited = new boolean[k];
		// �ˬd���V�ϬO�_���@����
		while (!queueRow.isEmpty()) {
			int node = queueRow.remove();
			if (!rowVisited[node]) {
				rowVisited[node] = true;
				// �Cvisit�L�@���I��A�u���v���ᮿ
				assignments[node][0] = rowNumber++;
				// �������I�Ҧ����s���I
				for (int child : rowGraph.get(node)) {
					rowInDegree[child]--;
					// ��̪����I�����г������N����I�]�����F�@�Ӳ��I
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
		// ��X���G
		int[][] answer = new int[k][k];
		for (int i = 0; i < k; i++) {
			// �����@�I�Svisited�N��Ӧ��V�Ϥ��O��
			if (!colVisited[i] || !rowVisited[i])
				return new int[][] {};
			answer[assignments[i][0]][assignments[i][1]] = i + 1;
		}
		return answer;
	}
}
