package top.L210;

import java.util.ArrayList;

public class Solution {
    int idx = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];

        // 建立拓譜圖
        ArrayList[] adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        for (int[] pair : prerequisites) {
            adjList[pair[0]].add(pair[1]);
        }

        // 拜訪表用來記錄修課狀況
        // 0 - 未修課
        // 1 - DFS查找修課中的暫時狀態
        // 2 - 已修課
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            // DFS找出可修完所有課的順序
            if (dfs(i, visited, adjList, res)) {
                return new int[0];
            }
        }
        return res;
    }

    private boolean dfs(int i, int[] visited, ArrayList<Integer>[] adjList, int[] res) {
        if (visited[i] == 2) {
            return false;
        }
        //要修該課前的課是否都修過了
        for (int req : adjList[i]) {
            //尚未修過
            if (visited[req] == 0) {
                // 先暫時改成查找中
                visited[i] = 1;
                // 以該點為主DFS
                if (dfs(req, visited, adjList, res)) {
                    return true;
                }
            } else if (visited[req] == 1) {
                // 遇到查找中的代表該修課順序不可能
                return true;
            }
        }
        // 修完該課並記錄於答案中
        visited[i] = 2;
        res[idx++] = i;
        return false;
    }
}