package top.L239;

class Solution {

    /**
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
    public int[] maxSlidingWindow(int[] arr, int k) {
        int[] ret = new int[arr.length - k + 1];
        // 紀錄兩種計算方向的MAX為多少
        int[] leftDirMax = new int[arr.length];
        int[] rightDirMax = new int[arr.length];
        // window一次位移k
        for (int i = 0; i < arr.length; i += k) {
            // 當前window右邊邊界
            int rightBound = Math.min(i + k - 1, arr.length - 1);
            int max = Integer.MIN_VALUE;
            // 從左邊開始往右的最大值紀錄
            for (int j = i; j <= rightBound; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
                rightDirMax[j] = max;
            }
            // 從右邊開始往左的最大值紀錄
            max = Integer.MIN_VALUE;
            for (int j = rightBound; j >= i; j--) {
                if (arr[j] > max) {
                    max = arr[j];
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
}