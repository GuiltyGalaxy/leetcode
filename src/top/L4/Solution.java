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
            // 取各自的mid
            int aMid = (start + end) / 2;
            int bMid = realMedInMergedArr - aMid;
            // 我們要尋找的目標是這條分隔線在切A跟B的時候，其分隔線兩邊數字要符合真正的中位數分隔線
            // 所以利用2分搜尋去尋找這條線的位子
            // 圖示
            // A : X X leftA |-> rightA O O
            // B : X X X leftB |-> rightB O O O
            int leftA = (aMid > 0) ? A[aMid - 1] : Integer.MIN_VALUE;
            int rightA = (aMid < n) ? A[aMid] : Integer.MAX_VALUE;
            int leftB = (bMid > 0) ? B[bMid - 1] : Integer.MIN_VALUE;
            int rightB = (bMid < m) ? B[bMid] : Integer.MAX_VALUE;

            // 當這條件達成時代表該分隔線是實質中位數分隔線
            // 也就是達成所有X的數字都小於O
            // A : X X leftA |-> rightA O O
            // B : X X X leftB |-> rightB O O O
            if (leftA <= rightB && leftB <= rightA) {
                // 偶數的情況要算2個
                if ((m + n) % 2 == 0) {
                    int maxLeft = Math.max(leftA, leftB);
                    int minRight = Math.min(rightA, rightB);
                    return (float) (maxLeft + minRight) / 2.0;
                }
                return Math.max(leftA, leftB);
            } else if (leftA > rightB) {
                end = aMid - 1;
            } else {
                start = aMid + 1;
            }
        }
        return 0.0;
    }
}