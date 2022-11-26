package top.L973;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    //O(Nlog(k))
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int p1 = Math.abs(a[0]) * Math.abs(a[0]) + Math.abs(a[1]) * Math.abs(a[1]);
            int p2 = Math.abs(b[0]) * Math.abs(b[0]) + Math.abs(b[1]) * Math.abs(b[1]);
            return p1 - p2;
        });

        pq.addAll(Arrays.asList(points));

        int[][] ans = new int[k][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }


    //O(N) quick select用在這問題上剛好可以很快(非線性解)
    public int[][] kClosest2(int[][] points, int k) {
        int len = points.length, L = 0, R = len - 1;
        while (L <= R) {
            int M = helper(points, L, R);
            if (M == k) break;
            if (M < k) {
                L = M + 1;
            } else {
                R = M - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, k);
    }

    private int helper(int[][] A, int L, int R) {
        int[] pivot = A[L];
        while (L < R) {
            while (L < R && compare(A[R], pivot) >= 0) R--;
            A[L] = A[R];
            while (L < R && compare(A[L], pivot) <= 0) L++;
            A[R] = A[L];
        }
        A[L] = pivot;
        return L;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}