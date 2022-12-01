package top.L547;

class Solution {

    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                //每走過一次代表一個集合
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int[] visited, int i) {
        //把i j對應之連接點全部找過
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && visited[j] == 0) {
                //找過則標記
                visited[j] = 1;
                //往下個點找
                dfs(isConnected, visited, j);
            }
        }
    }
}