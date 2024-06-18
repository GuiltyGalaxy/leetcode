package top.L1197;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {

    // 定義騎士的八個移動方向
    private static final int[][] DIRECTIONS = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
    };

    /**
     * 使用BFS
     */
    public int minKnightMoves(int x, int y) {
        // 因正負不影響最終結果，統一ABS轉換
        x = Math.abs(x);
        y = Math.abs(y);

        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // 初始化起點
        queue.offer(new int[]{0, 0});
        visited.add("0,0");
        int steps = 0;

        // BFS 搜索
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int cx = current[0];
                int cy = current[1];

                // 如果到達目標點
                if (cx == x && cy == y) {
                    return steps;
                }

                // 遍歷八個方向
                for (int[] direction : DIRECTIONS) {
                    int newX = cx + direction[0];
                    int newY = cy + direction[1];

                    // 轉換成自定義的字符串來檢查是否已經訪問過
                    String key = newX + "," + newY;
                    // 由於我們只找正的座標，且騎士最多移動2格，所以設置一個範圍減少不必要的search
                    boolean inRanger = newX >= -2 && newY >= -2;
                    if (!visited.contains(key) && inRanger) {
                        queue.offer(new int[]{newX, newY});
                        visited.add(key);
                    }
                }
            }
            steps++;
        }

        // 理論上不會到達這一步
        return -1;
    }

}