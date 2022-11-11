package top.L54;

import java.util.LinkedList;
import java.util.List;

class Solution {

    private int M = 0;
    private int N = 0;

    public List<Integer> spiralOrder(int[][] matrix) {
        M = matrix.length;
        N = matrix[0].length;
        //進行方向一定為{右下左上}循環
        int[][] dist = new int[][]{
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
        };
        List<Integer> ans = new LinkedList<>();
        //當前方向
        int curDist = 0;
        int x = 0, y = 0;

        for (int i = 0; i < M * N; i++) {

            ans.add(matrix[y][x]);
            //標記成已走過
            matrix[y][x] = Integer.MIN_VALUE;

            if (isChangeDist(matrix, dist[curDist], x, y)) {
                //依順序方向進行
                curDist = (curDist + 1) % 4;
            }
            //走下一個點
            x += dist[curDist][0];
            y += dist[curDist][1];
        }
        return ans;
    }

    /**
     * 預先檢查下個點是否需要變換方向
     *
     * @return ture:要
     */
    private boolean isChangeDist(int[][] matrix, int[] dist, int x, int y) {
        if (x + dist[0] >= N || x + dist[0] < 0) {
            return true;
        }
        if (y + dist[1] >= M || y + dist[1] < 0) {
            return true;
        }
        if (matrix[y + dist[1]][x + dist[0]] == Integer.MIN_VALUE) {
            return true;
        }
        return false;
    }
}