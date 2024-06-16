package top.L253;

import java.util.Arrays;

class Solution {
    public int minMeetingRooms(int[][] intervals) {

        int n = intervals.length;
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        // 拆分每個會議的起始與結束時間
        for (int i = 0; i < n; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int startPointer = 0;
        int endPointer = 0;
        int currentRooms = 0;
        int maxRooms = 0;

        while (startPointer < n) {
            // 由於兩數列都已排序過，所以只要最小結束時間大於當前起始時間就代表要加開會議室
            if (startTimes[startPointer] < endTimes[endPointer]) {
                // 有衝突就加開會議室
                currentRooms++;
                // 並且推移下個會議起始時間
                startPointer++;
            } else {
                // 沒衝突就釋放會議室
                currentRooms--;
                // 並且推移下個會議結束時間
                endPointer++;
            }
            maxRooms = Math.max(maxRooms, currentRooms);
        }

        return maxRooms;
    }
}