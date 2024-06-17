package top.L1730;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int getFood(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        // 定義方向組
        int[] directionsX = {-1, 1, 0, 0};
        int[] directionsY = {0, 0, -1, 1};

        // 找到起始點
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '*') {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    break;
                }
            }
        }

        int steps = 0;

        // 從起始點開始BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                // 检查是否到达食物
                if (grid[x][y] == '#') {
                    return steps;
                }

                // 往4個方向尋找
                for (int d = 0; d < 4; d++) {
                    int newX = x + directionsX[d];
                    int newY = y + directionsY[d];

                    // 檢查X範圍
                    if (newX < 0 || newX >= rows) {
                        continue;
                    }

                    // 檢查Y範圍
                    if (newY < 0 || newY >= cols) {
                        continue;
                    }

                    // 是否已經過
                    if (visited[newX][newY]) {
                        continue;
                    }

                    // 是否為牆壁
                    if (grid[newX][newY] == 'X') {
                        continue;
                    }

                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
            steps++;
        }

        return -1;
    }
}