package contest.wc409.L3243;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] ans = new int[queries.length];
        // 預設每個點到終點的距離
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = i;
        }

        // 初始化無向圖
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.getOrDefault(i, new ArrayList<>());
            list.add(i + 1);
            map.put(i, list);
        }

        for (int i = 0; i < queries.length; i++) {
            // 每次都新增一個路徑
            int[] q = queries[i];
            List<Integer> list = map.get(q[0]);
            list.add(q[1]);
            map.put(q[0], list);

            // 更新dp
            dfs(q[1], dp[q[0]], dp, map);

            // 每次紀錄最新終點的路成為多少
            ans[i] = dp[n - 1];
        }

        return ans;
    }

    private void dfs(int to, int len, int[] dp, Map<Integer, List<Integer>> map) {

        // 到終點不計算
        if (to == dp.length) {
            return;
        }

        len += 1;
        // 長度大於目前則不用在計算
        if(len >= dp[to]){
            return;
        }
        dp[to] = len;
        // 把每個路都算過一遍
        for (int i : map.get(to)) {
            dfs(i, len, dp, map);
        }
    }
}