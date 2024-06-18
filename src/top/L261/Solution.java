package top.L261;

import java.util.*;

/**
 * Graph Tree有兩種特性
 * 連通性:每個點必須可以到達全部點
 * 無環性:不能有循環路徑
 */
class Solution {

    /**
     * BFS
     */
    public boolean validTree(int n, int[][] edges) {

        // 少於n - 1代表不連通
        // 多餘n - 1代表有環
        if (edges.length != n - 1) {
            return false;
        }

        // 建立連結圖
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // BFS檢查是否有環
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        // 由於題目有指定，所以起點可設為0
        queue.offer(0);
        visited.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            // 找出該點所有相連點
            for (int neighbor : graph.get(node)) {
                // 已找過不處理
                if (visited.contains(neighbor)) {
                    continue;
                }
                queue.offer(neighbor);
                visited.add(neighbor);
                // 移除相鄰節點的自己避免重複查找
                // 這邊使用Integer轉型是為了避免使用到remove(int index)，我們要用的是remove(Object o)
                graph.get(neighbor).remove((Integer) node);
            }
        }

        // 有環的話經過的節點樹會大於n
        return visited.size() == n;
    }

    /**
     * DFS
     */
    public boolean validTree2(int n, int[][] edges) {

        if (edges.length != n - 1) {
            return false;
        }

        // 建立連結圖
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        if (hasCycle(graph, visited, 0, -1)) {
            return false;
        }

        // 檢查是否都經過
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, boolean[] visited, int node, int parent) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(graph, visited, neighbor, node)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // neighbor的延伸一定都是parent，如果有不是parent代表有環
                return true;
            }
        }

        return false;
    }

    /**
     * 使用並聯(UnionFind)查找
     */
    public boolean validTree3(int n, int[][] edges) {

        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return false;
            }
        }

        return true;
    }

    static class UnionFind {
        private final int[] parent;
        // 紀錄群組大小
        private final int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            // 當自己的群主非自己時，往下繼續找並設定成正確群組
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
            // 大的群組合併小的，都一樣的話取rootX
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }

}