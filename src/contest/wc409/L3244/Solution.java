package contest.wc409.L3244;


import java.util.HashMap;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // 該題增加了路徑數量
        // 不過移除重疊路徑的資料 ex. {2,4} {3,5}
        var ans = new int[queries.length];
        // 維護一個總表表示每個點目前連到的下個點
        // 其size就是最短路徑
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n - 1; i++) {
            map.put(i, i + 1);
        }

        for (int i = 0; i < queries.length; i++) {
            var start = queries[i][0];
            var end = queries[i][1];

            // 如果該點已經計算過，則不用再更新
            if (!map.containsKey(start) || map.get(start) >= end) {
                ans[i] = map.size();
                continue;
            }

            // 移除範圍內的節點
            var j = map.get(start);
            while (j < end) {
                j = map.remove(j);
            }
            // 更新對應
            map.put(start, end);

            ans[i] = map.size();
        }

        return ans;
    }
}