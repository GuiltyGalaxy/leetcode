package top.L1235;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int len = profit.length;
        // 建立Job
        Job[] jobs = new Job[len];
        for (int i = 0; i < len; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        // 按照結束時間排序
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.end));

        // dp紀錄job工作最大效益
        // index紀錄選擇工作的次數(最大情況就是所有工作都不衝突，全選)
        int[] dp = new int[len];
        // 先填入第一個最早結束的工作
        dp[0] = jobs[0].profit;

        for (int i = 1; i < len; i++) {

            int left = 0;
            int right = i - 1;
            // 本次所找到最佳目標
            int res = -1;

            // 由於是利用結束時間排序
            // 所以可以使用binary search去尋最Job中結束時間最接近本次起始時間的
            // 就可以於本次工作前加入其他工作
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (jobs[mid].end <= jobs[i].start) {
                    res = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            // 做本次job所獲的效益
            int doCurJob = jobs[i].profit;
            // 如果有找到匹配的則把匹配到的dp結果也加入
            if (res != -1) {
                doCurJob += dp[res];
            }

            // 不做本次job的效益
            int notDoCurJob = dp[i - 1];

            // 比較有效益的加入dp
            dp[i] = Math.max(doCurJob, notDoCurJob);
        }

        return dp[len - 1];
    }

    static class Job {
        int start;
        int end;
        int profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
}
