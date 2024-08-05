package contest.wc409.L3242;


import java.util.HashMap;
import java.util.Map;

class NeighborSum {

    private final Map<Integer, Integer> adj;
    private final Map<Integer, Integer> dia;

    public NeighborSum(int[][] grid) {
        // 在初始化就算好每一個可能性
        adj = new HashMap<>();
        dia = new HashMap<>();
        int n = grid.length;
        int m = grid[0].length;

        int[][] adjF = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] diaF = new int[][]{{1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        for (int i = 0; i < n; i++) {

            // 計算adj(4邊)
            for (int j = 0; j < m; j++) {
                int adjSum = 0;
                for (int[] f : adjF) {
                    int row = i + f[0];
                    int col = j + f[1];

                    if (row < 0 || row >= n || col < 0 || col >= m) {
                        continue;
                    }
                    adjSum += grid[row][col];
                }
                adj.put(grid[i][j], adjSum);
            }

            // 計算dia(4角)
            for (int j = 0; j < m; j++) {
                int diaSum = 0;
                for (int[] f : diaF) {
                    int row = i + f[0];
                    int col = j + f[1];

                    if (row < 0 || row >= n || col < 0 || col >= m) {
                        continue;
                    }

                    diaSum += grid[row][col];
                }
                dia.put(grid[i][j], diaSum);
            }

        }
    }

    public int adjacentSum(int value) {
        return adj.get(value);
    }

    public int diagonalSum(int value) {
        return dia.get(value);
    }
}
