package top.L759;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        // 先攤平所有員工的時間
        List<Interval> allIntervals = new ArrayList<>();
        for (List<Interval> intervals : schedule) {
            allIntervals.addAll(intervals);
        }

        // 以起始時間為依據排序
        allIntervals.sort(Comparator.comparingInt(a -> a.start));

        List<Interval> result = new ArrayList<>();
        // prevEnd用來記錄目前該區間最後時間
        int prevEnd = allIntervals.get(0).end;

        for (Interval interval : allIntervals) {
            // 當下一個的起始時間大於目前結束時間，代表有空閒時段出來了
            if (interval.start > prevEnd) {
                result.add(new Interval(prevEnd, interval.start));
            }
            // 更新最後時間
            prevEnd = Math.max(prevEnd, interval.end);
        }

        return result;
    }
}