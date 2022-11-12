package daily.L295;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    private boolean even = true;

    public MedianFinder() {
        //反向排序
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public double findMedian() {
        if (even) {
            //兩個queue的peek就為中位數
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return small.peek();
        }
    }

    public void addNum(int num) {
        //odd even來回增加至指定queue
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }
}