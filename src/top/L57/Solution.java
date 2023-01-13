package top.L57;

import java.util.LinkedList;

class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        LinkedList<int[]> ans = new LinkedList<>();
        int idx = 0;

        //尋找起點
        while (idx < intervals.length) {
            if (intervals[idx][0] < newInterval[0]) {
                ans.add(intervals[idx]);
                idx++;
            } else {
                //找到比newInterval[0]大的就停住
                break;
            }
        }

        if (ans.size() == 0 || (newInterval[0] > ans.getLast()[1])) {
            //代表newInterval完全沒有overlapping於intervals，且為最後面
            ans.add(newInterval);
        } else {
            //取最後一組比較[1]的大小替換
            int[] lastInterval = ans.getLast();
            lastInterval[1] = Math.max(lastInterval[1], newInterval[1]);
        }

        while (idx < intervals.length) {
            int[] lastInterval = ans.getLast();
            //不斷比較lastInterval直到下一組的intervals[0]大於lastInterval[1]
            if (lastInterval[1] >= intervals[idx][0]) {
                lastInterval[1] = Math.max(lastInterval[1], intervals[idx][1]);
            } else {
                ans.add(intervals[idx]);
            }
            idx++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}