package top.L1235;

import java.util.Arrays;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] map = new int[n][3];

        //以endTime排序
        for (int i = 0; i < n; i++) {
            map[i][0] = startTime[i];
            map[i][1] = endTime[i];
            map[i][2] = profit[i];
        }

        Arrays.sort(map, (a, b) -> a[1] - b[1]);

        int[] maxProfit = new int[n];
        maxProfit[0] = map[0][2];

        for (int i = 1; i < n; i++) {
            int prvIndex = i - 1;
            int start = map[i][0];
            int earn = map[i][2];

            if (map[prvIndex][1] > start) {
                //prv end有重疊到當前的start
                //prvIndex往前移到end < start為止
                while (prvIndex >= 0 && map[prvIndex][1] > start) {
                    prvIndex--;
                }

                if (prvIndex >= 0) {
                    //有找到前一個不重疊的區域，則代表profit是可以疊加前一個的
                    maxProfit[i] = Math.max(maxProfit[prvIndex] + earn, maxProfit[i - 1]);
                } else {
                    //沒有的情況下(prvIndex==-1)，就只能單獨比profit
                    maxProfit[i] = Math.max(earn, maxProfit[i - 1]);
                }
            } else {
                //沒重疊直接將profit加上
                maxProfit[i] = maxProfit[prvIndex] + earn;
            }
        }

        return maxProfit[n - 1];
    }
}