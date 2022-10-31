package leetcode.L1293;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        //紀錄是否visit
        boolean[][][] visited = new boolean[n][m][k + 1];
        visited[0][0][0] = true;
        //q中的資料為int[3]
        //int[0] X座標
        //int[1] Y座標
        //int[2] 已遇到的障礙物數
        q.offer(new int[]{0, 0, 0});
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] info = q.poll();
                int x = info[0];
                int y = info[1];
                int curK = info[2];
                //到達終點
                if (x == n - 1 && y == m - 1) {
                    return step;
                }
                //往4個方向都走一遍
                for (int[] dir : dirs) {
                    int nextX = dir[0] + x;
                    int nextY = dir[1] + y;
                    int nextK = curK;
                    //還沒到邊才繼續計算
                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                        //遇到障礙
                        if (grid[nextX][nextY] == 1) {
                            nextK++;
                        }
                        //符合的條件加入q中做下一輪的搜尋
                        if (nextK <= k && !visited[nextX][nextY][nextK]) {
                            visited[nextX][nextY][nextK] = true;
                            q.offer(new int[]{nextX, nextY, nextK});
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}