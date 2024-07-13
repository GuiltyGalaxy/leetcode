package top.L994;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        // 紀錄總共有幾個新鮮的
        int fresh = 0;
        //BFS queue
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        // 如果fresh已經都沒了就不用繼續算
        while (!queue.isEmpty() && fresh != 0) {
            ans++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int[] dir : directions) {
                    int row = point[0] + dir[0];
                    int col = point[1] + dir[1];
                    if (row < 0 || row >= n) {
                        continue;
                    }
                    if (col < 0 || col >= m) {
                        continue;
                    }
                    if (grid[row][col] == 1) {
                        fresh--;
                        grid[row][col] = 2;
                        queue.add(new int[]{row, col});
                    }
                }
            }
        }

        return fresh == 0 ? ans : -1;
    }
}