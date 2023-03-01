package top.L542;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[][] updateMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        //掃描全部0的位子
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        //從0的點開始進行BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                //邊緣檢測
                if (r < 0 || r >= m) {
                    continue;
                }
                if (c < 0 || c >= n) {
                    continue;
                }
                //如果四周的cell比原cell小則不異動
                if (matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) {
                    continue;
                }
                //加入下次掃瞄範圍
                queue.add(new int[]{r, c});
                //該點累加
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }

        return matrix;
    }
}