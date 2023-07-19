package top.L703;

import java.util.Arrays;
import java.util.PriorityQueue;

class KthLargest {
    private final PriorityQueue<Integer> pq = new PriorityQueue<>();
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        Arrays.stream(nums).forEach(this::add);
    }

    public int add(int val) {

        pq.offer(val);
        // 只保留前k大的數
        if (pq.size() > k) {
            pq.poll();
        }

        assert !pq.isEmpty();
        // 由於只保留前k大的數
        // 第一個元素就是目標
        return pq.peek();
    }
}