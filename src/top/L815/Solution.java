package top.L815;

import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {

        if (source == target) {
            return 0;
        }

        // 找最大站號
        int maxStation = 0;
        // 依照最大站號生成連接圖
        // stationToRoute[5]{1,2}代表1號轉運站、2號轉運站都可到5號站
        Map<Integer, List<Integer>> stationToRoute = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int station : routes[i]) {
                List<Integer> list = stationToRoute.getOrDefault(station, new ArrayList<>());
                list.add(i);
                stationToRoute.put(station, list);
                maxStation = Math.max(maxStation, station);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> genRoute = new HashSet<>();
        // DP
        int[] dp = new int[maxStation + 1];

        // BFS找最小換車次數
        queue.offer(source);
        while (!queue.isEmpty()) {
            int curStation = queue.poll();
            // 找遍從當前站可到達的轉運站有哪些
            for (int route : stationToRoute.get(curStation)) {
                // 排除已經過的轉運站
                if (genRoute.contains(route)) {
                    continue;
                }
                // 找出該轉運站底下所有站別
                for (int station : routes[route]) {
                    // 排除同站
                    if (station != curStation) {
                        // 該站還沒被找過
                        if (dp[station] == 0) {
                            // 更新DP，依據為上一站的轉站次數
                            dp[station] = dp[curStation] + 1;
                            queue.add(station);
                        }
                        // 找到目標，回傳當前DP
                        if (station == target) {
                            return dp[station];
                        }
                    }
                }
                // 轉運站已經過就不用再找了
                genRoute.add(route);
            }
        }
        return -1;
    }
}