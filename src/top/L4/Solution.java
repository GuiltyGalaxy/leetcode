package top.L4;

class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {

        int n = A.length;
        int m = B.length;
        // 比較長的擺後面
        if (n > m) {
            return findMedianSortedArrays(B, A);
        }

        int realMedInMergedArr = (m + n + 1) / 2;
        int start = 0;
        int end = n;

        while (start <= end) {
            int mid = (start + end) / 2;
            // 取各自的mid
            // mid增加，leftASize->>> <<<-leftBSize
            // mid減少，<<<-leftASize leftBSize->>>
            int leftASize = mid;
            int leftBSize = realMedInMergedArr - mid;
            // 2個array前後各設置指標
            // 所以會有4個指標去比較
            // left是小數指標，超出範圍用Integer.MIN_VALUE替代
            int leftA = (leftASize > 0) ? A[leftASize - 1] : Integer.MIN_VALUE;
            int leftB = (leftBSize > 0) ? B[leftBSize - 1] : Integer.MIN_VALUE;
            // right是大數指標，超出範圍用Integer.MAX_VALUE替代
            int rightA = (leftASize < n) ? A[leftASize] : Integer.MAX_VALUE;
            int rightB = (leftBSize < m) ? B[leftBSize] : Integer.MAX_VALUE;

            // 達成條件表示該指標兩邊所代表的數字為all mid
            if (leftA <= rightB && leftB <= rightA) {
                // 偶數的情況要算2個
                if ((m + n) % 2 == 0) {
                    int maxLeft = Math.max(leftA, leftB);
                    int minRight = Math.min(rightA, rightB);
                    return (float) (maxLeft + minRight) / 2.0;
                }
                return Math.max(leftA, leftB);
            } else if (leftA > rightB) {
                // A最小比B最大大則要向外靠
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 0.0;
    }
}