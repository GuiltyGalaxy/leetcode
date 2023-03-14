package top.L417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private int M;
    private int N;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        M = heights.length;
        N = heights[0].length;
        boolean[][] pac = new boolean[M][N];
        boolean[][] atl = new boolean[M][N];

        //上下兩邊做起點掃描
        for (int col = 0; col < N; col++) {
            dfs(0, col, pac, heights[0][col], heights);
            dfs(M - 1, col, atl, heights[M - 1][col], heights);
        }

        //左右兩邊做起點掃描
        for (int row = 0; row < M; row++) {
            dfs(row, 0, pac, heights[row][0], heights);
            dfs(row, N - 1, atl, heights[row][N - 1], heights);
        }

        List<List<Integer>> result = new ArrayList<>();
        //兩邊都有辦法達到的地方就是最高點
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (pac[i][j] && atl[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int row, int col, boolean[][] visited, int prevHeight, int[][] heights) {

        if (row < 0 || row >= M || col < 0 || col >= N) {
            return;
        }

        //已走過或比先前的高
        if (visited[row][col] || prevHeight > heights[row][col]) {
            return;
        }

        visited[row][col] = true;

        dfs(row + 1, col, visited, heights[row][col], heights);
        dfs(row - 1, col, visited, heights[row][col], heights);
        dfs(row, col + 1, visited, heights[row][col], heights);
        dfs(row, col - 1, visited, heights[row][col], heights);
    }
}