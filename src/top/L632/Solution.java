package top.L632;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    /**
     * O(N log K) PriorityQueue
     */
    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int max = Integer.MIN_VALUE;

        // 初始化queue，拿取每個list第一個值，並記錄最大值為和
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);
            minHeap.add(new int[]{value, i, 0});
            max = Math.max(max, value);
        }

        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;

        // 由於minHeap中會一直把最小的元素list移至最前
        // 只要有一個list被處理完就代表range符合
        while (minHeap.size() == nums.size()) {
            int[] current = minHeap.poll();
            // 每個list資訊
            // 最小元素
            int min = current[0];
            // 第幾個list
            int row = current[1];
            // 算到list第幾個
            int index = current[2];

            // 只要範圍比當前大就更新range
            if (max - min < rangeEnd - rangeStart) {
                rangeStart = min;
                rangeEnd = max;
            }

            // 移動min到list中下一個元素
            if (index + 1 < nums.get(row).size()) {
                int nextValue = nums.get(row).get(index + 1);
                minHeap.add(new int[]{nextValue, row, index + 1});
                max = Math.max(max, nextValue);
            }
        }

        return new int[]{rangeStart, rangeEnd};
    }

    /**
     * O(N log N) 2 point 窗口
     */
    public int[] smallestRange2(List<List<Integer>> nums) {

        // 把nums攤平成一維List
        List<int[]> sortedList = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int num : nums.get(i)) {
                // [i列的數字,i列]
                sortedList.add(new int[]{num, i});
            }
        }

        sortedList.sort(Comparator.comparingInt(a -> a[0]));

        // 紀錄該窗口中每個list元素出現次數
        int[] freq = new int[nums.size()];
        // 雙指針紀錄窗口範圍
        int start = 0;
        int end = 0;
        // 已包含的list數量
        int listInCount = 0;
        int minRange = Integer.MAX_VALUE;

        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;

        while (end < sortedList.size()) {
            // 增加元素
            int[] current = sortedList.get(end);
            if (freq[current[1]] == 0) {
                listInCount++;
            }
            freq[current[1]]++;

            // 當listInCount == nums.size()代表目前窗口已包含全部元素，可嘗試縮小窗口
            // 但start與end如果以相等或反超則不用再計算
            while (listInCount == nums.size() && start <= end) {
                // 比較當前range
                int range = sortedList.get(end)[0] - sortedList.get(start)[0];
                if (range < minRange) {
                    minRange = range;
                    rangeStart = sortedList.get(start)[0];
                    rangeEnd = sortedList.get(end)[0];
                }
                // 移除元素
                int[] removed = sortedList.get(start);
                freq[removed[1]]--;
                if (freq[removed[1]] == 0) {
                    listInCount--;
                }
                start++;
            }

            end++;
        }

        return new int[]{rangeStart, rangeEnd};
    }

}