package top.L295;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    private final PriorityQueue<Integer> maxHeap;
    private final PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        // 這邊max表示數量較大的意思，非數字大就放過來
        // 假設總堆為 1 2 3 4 5 6 7
        // 排序會為 4 3 2 1
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // 排序會為 5 6 7
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 主要先從maxHeap開始放
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // 讓兩maxHeap剛好等同於minHeap或大於1
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        if (maxHeap.size() == 0) {
            return 0.0;
        }

        if (maxHeap.size() == minHeap.size()) {
            // 大小相等時就兩邊取
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            // 由於每次addNum都有維護maxHeap，當數量不同拾取maxHeap即可
            return maxHeap.peek();
        }
    }
}