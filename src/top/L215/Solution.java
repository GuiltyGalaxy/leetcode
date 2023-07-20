package top.L215;


import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Arrays.stream(nums).forEach(pq::add);
        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        assert !pq.isEmpty();
        return pq.peek();
    }
}