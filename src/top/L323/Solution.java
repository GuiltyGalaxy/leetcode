package top.L323;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int countComponents(int n, int[][] edges) {
        // 建立雙向圖
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // 每遇到一個沒經過的就把結果+1
                count++;
                // 以當前節點去做DFS
                dfs(graph, visited, i);
            }
        }

        return count;
    }

    private void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }
}