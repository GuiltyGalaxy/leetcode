package top.L239;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    /**
     * 跟Deque都是O(n) 但少了維護Deque的操作實際上快了一些
     * 計算原理
     * 假設arr[8] = 1,3,-1,-3,5,3,6,7
     * k = 5
     * 我們可以知道會有 8-5+1 = 4個window[x]出現
     * 然後我們用兩個arr去統計從兩個方向計算最大值，設為L->R、R->L
     * window1 = 1,3,-1,-3,5
     * - L->R  = 1,3,3,3,5
     * - R->L  = 5,5,5,5,5
     * window2 = 3,-1,-3,5,3
     * - L->R  = 3,3,3,5,5
     * - R->L  = 5,5,5,5,3
     * window3 = -1,-3,5,3,6
     * - L->R  = -1,-1,5,5,6
     * - R->L  = 6,6,6,6,6
     * window4 = -3,5,3,6,7
     * - L->R  = -3,5,5,6,7
     * - R->L  = 7,7,7,7,7
     * 由上述統計觀察可發現
     * 每個window最大值會為
     * Math.max(L->R[x+k],R->L[x])
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ret = new int[nums.length - k + 1];
        // 紀錄兩種計算方向的MAX為多少
        int[] leftDirMax = new int[nums.length];
        int[] rightDirMax = new int[nums.length];
        // window一次位移k
        for (int i = 0; i < nums.length; i += k) {
            // 當前window右邊邊界
            int rightBound = Math.min(i + k - 1, nums.length - 1);
            int max = Integer.MIN_VALUE;
            // 從左邊開始往右的最大值紀錄
            for (int j = i; j <= rightBound; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
                rightDirMax[j] = max;
            }
            // 從右邊開始往左的最大值紀錄
            max = Integer.MIN_VALUE;
            for (int j = rightBound; j >= i; j--) {
                if (nums[j] > max) {
                    max = nums[j];
                }
                leftDirMax[j] = max;
            }
        }
        // 開始計算每個window的最大值
        for (int i = 0; i < ret.length; i++) {
            // 記錄尾端
            int end = i + k - 1;
            // 比較兩方向統計的最大值
            ret[i] = Math.max(rightDirMax[end], leftDirMax[i]);
        }
        return ret;
    }

    /**
     * Deque O(n)
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        // 維護一個ArrayDeque,其中第一個index一定是目前窗口中最大值
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 移出超出窗口的index
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 將比當前數字小的index從尾端依序移除
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 將當前index加入
            deque.offerLast(i);

            // 如果result尚未填滿則將該次結果填入
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}