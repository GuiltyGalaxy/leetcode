package contest.wc406.L3218;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        // 紀錄該線是否被切過
        boolean[][] isCut = new boolean[m - 1][n - 1];
        // 紀錄每個切點{cost,index,橫切還直切}
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < horizontalCut.length; i++) {
            list.add(new int[]{horizontalCut[i], i, 0});
        }
        for (int i = 0; i < verticalCut.length; i++) {
            list.add(new int[]{verticalCut[i], i, 1});
        }
        // 按照cost排序，cost最多的先切
        list.sort(Comparator.comparingInt(a -> -a[0]));

        int total = 0;
        for (int[] info : list) {
            int cost = info[0];
            int cut = info[1];
            boolean isH = info[2] == 0;
            total += cost;
            if (isH) {
                for (int i = 0; i < isCut[0].length; i++) {
                    // 經過被切過的點要再多切一次
                    if (isCut[cut][i]) {
                        total += cost;
                    }
                    isCut[cut][i] = true;
                }
            } else {
                for (int i = 0; i < isCut.length; i++) {
                    if (isCut[i][cut]) {
                        total += cost;
                    }
                    isCut[i][cut] = true;
                }
            }

        }

        return total;
    }
}