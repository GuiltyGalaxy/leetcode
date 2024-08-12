package contest.wc410.L3249;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    int ans = 0;

    public int countGoodNodes(int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        // 紀錄該數字是否已連過
        boolean[] isIn = new boolean[100000];
        for (int[] e : edges) {
            // 為確保方向性，0一定在前面，或是已出現過的數字也一定在前面
            if (e[1] == 0 || isIn[e[1]]) {
                int tmp = e[1];
                e[1] = e[0];
                e[0] = tmp;
            }
            List<Integer> list = map.getOrDefault(e[0], new ArrayList<>());
            list.add(e[1]);
            map.put(e[0], list);
            isIn[e[0]] = true;
            isIn[e[1]] = true;
        }
        // 從0開始計算有多少GoodNode
        cntNode(map, 0);
        return ans;
    }

    private int cntNode(Map<Integer, List<Integer>> map, int node) {

        List<Integer> list = map.get(node);
        // 空節點算一個GoodNode
        if (list == null) {
            ans++;
            return 0;
        }

        // 計算所有相連的node底下有多少node
        int[] nodeCnt = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nodeCnt[i] = cntNode(map, list.get(i)) + 1;
        }

        int totalNode = 0;
        boolean isGoodNode = true;
        for (int cnt : nodeCnt) {
            if (nodeCnt[0] != cnt) {
                isGoodNode = false;
            }
            totalNode += cnt;
        }

        // 當所有nodeCnt都相等，則該點也為GoodNode
        if (isGoodNode) {
            ans++;
        }

        // 回傳該節點底下有多少node
        return totalNode;
    }

}