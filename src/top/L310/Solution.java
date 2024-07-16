package top.L310;

import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (edges.length == 0 || n == 1) {
            return List.of(0);
        }

        ArrayList<Integer>[] adj = new ArrayList[n];
        // 該點的連接數
        int[] degree = new int[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // 建立雙向連結圖
        for (int[] e : edges) {
            int v = e[0];
            int u = e[1];

            adj[v].add(u);
            adj[u].add(v);
            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // 先從連接線只有一條的(degree==1)移除掉
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.add(i);
            }
        }

        // 依序移除最外層的連接點
        // 當移除到剩下1點(偶數2點)時代表該點為最小高度節點
        while (n > 2) {

            int size = q.size();
            n -= size;

            while (size-- > 0) {
                int remove = q.remove();
                // 移除所有相關連接點
                for (int i : adj[remove]) {
                    degree[i]--;
                    // 移除後如果該點也只剩一個連線則加入下輪移除
                    if (degree[i] == 1) {
                        q.add(i);
                    }
                }
            }
        }

        return q.stream().toList();
    }
}