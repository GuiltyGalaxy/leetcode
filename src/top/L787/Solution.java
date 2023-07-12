package top.L787;

import java.util.Arrays;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 初始化
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        // 起始點花費為0
        cost[src] = 0;
        // 限制停的站數
        for (int i = 0; i <= k; i++) {
            // 暫存cost用來計算最便宜路線
            int[] temp = Arrays.copyOf(cost, n);
            // 找遍所有可能班機去計算
            for (int[] f : flights) {
                int curr = f[0];
                int next = f[1];
                int price = f[2];
                // 代表還沒經過不用計算
                if (cost[curr] == Integer.MAX_VALUE) {
                    continue;
                }
                // 比較當前路線是否有比上一個路線便宜
                temp[next] = Math.min(temp[next], cost[curr] + price);
            }
            // 將暫存返還
            cost = temp;
        }

        // -1代表沒有任何可能性到終點
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}