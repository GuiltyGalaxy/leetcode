package top.L435;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    //排序做法nLog(n)
    public int eraseOverlapIntervals(int[][] intervals) {

        //包含自己所以從1開始
        int counts = 1;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int end = intervals[0][1];
        int n = intervals.length;
        for (int i = 1; i < n; i++) {
            //只計算連續部分
            if (intervals[i][0] >= end) {
                counts++;
                //更新end
                end = Math.max(intervals[i][1], end);
            }
        }
        //counts是連續的部分，所以總長減去counts就是多出來的
        return n - counts;
    }

    //非排序 n
    public int eraseOverlapIntervals2(int[][] intervals) {

        int n = intervals.length;
        int max = intervals[n - 1][1];
        int min = max;

        //先找出結尾最大與最小值
        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(max, intervals[i][1]);
            min = Math.min(min, intervals[i][1]);
        }

        int diff = 1 - min;
        int size = max - min + 2;

        int[] f = new int[size];
        for (int[] interval : intervals) {
            int lo = interval[0] + diff;
            int hi = interval[1] + diff;

            if (lo > f[hi]) {
                f[hi] = lo;
            }
        }

        int count = 1;
        int prior = 1;

        for (int i = 1; i < size; i++) {
            if (f[i] >= prior) {
                prior = i;
                count++;
            }
        }
        return n - count;
    }
}