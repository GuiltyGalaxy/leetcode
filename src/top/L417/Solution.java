package top.L417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private int N;
    private int M;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        N = heights.length;
        M = heights[0].length;
        boolean[][] pac = new boolean[N][M];
        boolean[][] atl = new boolean[N][M];

        // 從4個邊為起點去往下推算
        // 只要兩邊都可到達就為最高點
        // 上下兩邊做起點掃描
        for (int col = 0; col < M; col++) {
            dfs(heights, pac, heights[0][col], 0, col);
            dfs(heights, atl, heights[N - 1][col], N - 1, col);
        }

        // 左右兩邊做起點掃描
        for (int row = 0; row < N; row++) {
            dfs(heights, pac, heights[row][0], row, 0);
            dfs(heights, atl, heights[row][M - 1], row, M - 1);
        }

        List<List<Integer>> result = new ArrayList<>();
        // 兩邊都有辦法達到的地方就是最高點
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (pac[i][j] && atl[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int prevHeight, int row, int col) {

        if (row < 0 || row >= N || col < 0 || col >= M) {
            return;
        }

        // 已走過不處理
        // 由於我們是從4個邊反過來推算高點，所以前一個點一定要比該點低才算達成條件
        if (visited[row][col] || prevHeight > heights[row][col]) {
            return;
        }

        visited[row][col] = true;

        // 往4個方向繼續推算
        dfs(heights, visited, heights[row][col], row + 1, col);
        dfs(heights, visited, heights[row][col], row - 1, col);
        dfs(heights, visited, heights[row][col], row, col + 1);
        dfs(heights, visited, heights[row][col], row, col - 1);
    }
}