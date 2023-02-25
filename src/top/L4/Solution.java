package top.L4;

public class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        // l == r 代表 m+n 是 even，getkth回傳會相同
        // l != r 代表 m+n 是 odd
        return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
    }

    /**
     * 取得兩數組中排第Kth的元素
     */
    private double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        //超過邊界的情況下代表該數組內沒有Kth元素存在，回傳另一數組目前的Kth元素
        if (aStart > A.length - 1) return B[bStart + k - 1];
        if (bStart > B.length - 1) return A[aStart + k - 1];
        //k==1代表沒辦法再切了，回傳數組比較小的
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        //start為偏移量，故start + k / 2 - 1為目標中數位子
        int aIdx = aStart + k / 2 - 1;
        int bIdx = bStart + k / 2 - 1;
        //取得中位數
        int aMid = aIdx < A.length ? A[aIdx] : Integer.MAX_VALUE;
        int bMid = bIdx < B.length ? B[bIdx] : Integer.MAX_VALUE;

        //比較小的中位數數組則將k/2前的數移除不做處理
        //也就是start=index+1，並且目標Kth = k - k/2
        if (aMid < bMid)
            return getkth(A, aIdx + 1, B, bStart, k - k / 2);
        else
            return getkth(A, aStart, B, bIdx + 1, k - k / 2);
    }
}