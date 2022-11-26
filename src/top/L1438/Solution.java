package top.L1438;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int longestSubarray(int[] nums, int limit) {

        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int ans = 1;
        int L = 0;

        for (int R = 0; R < nums.length; R++) {

            //將目前window的max與min更新至deque
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[R]) {
                maxDeque.removeLast();
            }
            maxDeque.addLast(nums[R]);

            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[R]) {
                minDeque.removeLast();
            }
            minDeque.addLast(nums[R]);

            //window的max與min差超過limit則移動L至符合條件
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                //檢查maxDeque minDeque是否有L在First，有的話則移除
                if (maxDeque.peekFirst() == nums[L]) maxDeque.pollFirst();
                if (minDeque.peekFirst() == nums[L]) minDeque.pollFirst();
                L++;
            }

            ans = Math.max(ans, R - L + 1);
        }

        return ans;
    }
}