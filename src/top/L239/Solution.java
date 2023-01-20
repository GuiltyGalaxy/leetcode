package top.L239;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int idx = 0;
        Deque<Integer> window = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {

            //window過長時移除最前端
            while (!window.isEmpty() && window.peek() < i - k + 1) {
                window.poll();
            }

            //確保window最前端是最大值
            while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
                window.pollLast();
            }

            window.offer(i);
            if (i >= k - 1) {
                ans[idx++] = nums[window.peek()];
            }
        }
        return ans;
    }

    /**
     将链表 切分成大小为 k 的 chunk
     然后 left 记录在 chunk 内从左往右的最大值,
     right 记录 chunk 内从右往左的最大值
     滑动窗口只需要找 right[i] 和 left[i + k - 1]的最大值
             1  3  -1  * -3  5  3  *  6  7
     left    1  3  3     -3  5  5     6  7
     right   3  3  -1     5  5  3     7  7

     TC: O(N)    SC: O(N) 16ms
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int[] L = new int[n];
        int[] R = new int[n];
        for (int i = 0; i < n; i += k) {
            int max = Integer.MIN_VALUE;
            int bound = Math.min(i + k - 1, n - 1);
            // from left to right -->
            for (int j = i; j <= bound; j++) {
                if (nums[j] > max)
                    max = nums[j];
                L[j] = max;
            }
            // from right to left <--
            max = Integer.MIN_VALUE;
            for (int j = bound; j >= i; j--) {
                if (nums[j] > max)
                    max = nums[j];
                R[j] = max;
            }
        }
        for (int i = 0; i < n - k + 1; i++) {
            int j = i + k - 1;
            res[i] = Math.max(R[i], L[j]);
        }
        return res;
    }
}