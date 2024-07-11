package top.L542;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * 使用BFS
     */
    public int[][] updateMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        // 掃描全部0的位子
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // 定義方向數組
        int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // 從0的點開始進行BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            // 4個方向都檢測一遍
            for (int[] d : dist) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                // 邊緣檢測
                if (r < 0 || r >= m) {
                    continue;
                }
                if (c < 0 || c >= n) {
                    continue;
                }
                // 如果更新後的結果相同或是小於當前基準點則不異動
                if (matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) {
                    continue;
                }
                // 加入下次計算範圍
                queue.add(new int[]{r, c});
                // 該點累加
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }

        return matrix;
    }

    /**
     * 使用4邊掃描
     */
    public int[][] updateMatrix2(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        // 先把全部的1都當作離陸地最遠
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 1) {
                    // 下面計算要先+1會超出範圍，所以要-1
                    matrix[row][col] = Integer.MAX_VALUE - 1;
                }
            }
        }

        // 該計算方式透過由4個邊當作起點去更新所有的點
        // 這樣最後更新出來的結果就一定是離0最近距離
        // 由上到下更新
        for (int row = 0; row < m; row++) {
            // 從col頭計算
            for (int col = 1; col < n; col++) {
                matrix[row][col] = Math.min(matrix[row][col], matrix[row][col - 1] + 1);
            }
            // 從col尾計算
            for (int col = n - 2; col >= 0; col--) {
                matrix[row][col] = Math.min(matrix[row][col], matrix[row][col + 1] + 1);
            }
        }

        // 由左至右更新
        for (int col = 0; col < n; col++) {
            // 從row頭計算
            for (int row = 1; row < m; row++) {
                matrix[row][col] = Math.min(matrix[row][col], matrix[row - 1][col] + 1);
            }
            // 從row尾計算
            for (int row = m - 2; row >= 0; row--) {
                matrix[row][col] = Math.min(matrix[row][col], matrix[row + 1][col] + 1);
            }
        }

        return matrix;
    }
}