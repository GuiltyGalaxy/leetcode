package top.L310;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (edges.length == 0 || n == 1) {
            return List.of(0);
        }

        //初始化
        ArrayList<Integer>[] adj = new ArrayList[n];
        int[] degree = new int[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        //建立連結圖
        for (int[] e : edges) {
            int v = e[0];
            int u = e[1];

            adj[v].add(u);
            adj[u].add(v);
            degree[u]++;
            degree[v]++;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        //先從連接線只有一條的(degree==1)移除掉
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }

        //最少要有兩個點才可以移除
        while (n > 2) {

            int size = queue.size();
            n -= size;

            while (size-- > 0) {

                int rem = queue.remove();
                //移除所有相關連接點
                for (int i : adj[rem]) {
                    degree[i]--;
                    //移除後如果該點也只剩一個連線則加入下輪名單
                    if (degree[i] == 1) {
                        queue.add(i);
                    }
                }
            }
        }

        //最後一輪的點就會是Minimum Height Trees的可能點
        ArrayList<Integer> res = new ArrayList<>();
        while (queue.size() > 0) {
            res.add(queue.pop());
        }

        return res;
    }
}