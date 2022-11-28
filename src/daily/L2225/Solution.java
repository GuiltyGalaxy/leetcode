package daily.L2225;

import java.util.*;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        //建立map
        //k:player
        //v:loss cnt
        Map<Integer, Integer> tracker = new HashMap<>();
        for (int[] match : matches) {
            //不再tracker代表沒輸過，預設給0
            if (!tracker.containsKey(match[0])) {
                tracker.put(match[0], 0);
            }
            tracker.put(match[1], tracker.getOrDefault(match[1], 0) + 1);
        }
        List<Integer> winners = new ArrayList<>();
        List<Integer> losers = new ArrayList<>();
        tracker.forEach((k, v) -> {
            if (v == 0) {
                winners.add(k);
            }
            if (v == 1) {
                losers.add(k);
            }
        });
        Collections.sort(winners);
        Collections.sort(losers);

        return List.of(winners, losers);
    }
}