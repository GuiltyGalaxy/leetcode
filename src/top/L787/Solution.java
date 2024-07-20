package top.L787;

import java.util.Arrays;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 記錄每一個點的花費金額
        // 並將src的點設為0
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        // 由於有限制要在k次內到目的地
        // 所以只找到k即可
        for (int i = 0; i <= k; i++) {
            // 為了避免去異動到cost[curr]
            // 所以先用temp去計算本次結果
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
                // 比較所飛到的下個點是否已有其他路線優於本次路線
                temp[next] = Math.min(temp[next], cost[curr] + price);
            }
            // 計算完後將結果更新至cost
            cost = temp;
        }

        // 所要到達的目的為Integer.MAX_VALUE代表沒有任何可能性到終點
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}