package top.L973;

import java.util.PriorityQueue;
import java.util.Random;

class Solution {

    //平均O(N) quick select
    private final Random rand = new Random();

    //O(Nlog(k))
    public int[][] kClosest(int[][] points, int k) {
        // 利用數學公式來計算兩點誰比較近
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
                (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // 提取對應的k
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }

    public int[][] kClosest2(int[][] points, int K) {
        quickSelect(points, 0, points.length - 1, K);
        int[][] result = new int[K][2];
        // 排序後取前K點就為解答
        System.arraycopy(points, 0, result, 0, K);
        return result;
    }

    private void quickSelect(int[][] points, int left, int right, int K) {
        // 左邊點的數量比右邊大就不計算了
        if (left >= right) return;

        // 隨機選擇一個點作為基準點
        int pivotIndex = left + rand.nextInt(right - left + 1);
        int pivotDist = dist(points[pivotIndex]);

        // 將基準點移到最右邊
        swap(points, pivotIndex, right);

        int partitionIndex = partition(points, left, right, pivotDist);

        // 如果partitionIndex - left + 1 == K代表滿足條件不繼續算
        if (K < partitionIndex - left + 1) {
            // 結果數量大於K繼續縮小範圍
            quickSelect(points, left, partitionIndex - 1, K);
        } else if (K > partitionIndex - left + 1) {
            // 結果數量小於K繼續擴大範圍
            quickSelect(points, partitionIndex + 1, right, K - (partitionIndex - left + 1));
        }
    }

    /**
     * 以pivotDist為基準區分points成left與right
     * 最後結果points left到right的區間會被依照與pivotDist比較大小的結果分為左右兩邊
     * 回傳partitionIndex來表示最終切分點位子
     */
    private int partition(int[][] points, int left, int right, int pivotDist) {
        int l = left;
        for (int r = left; r < right; r++) {
            if (dist(points[r]) <= pivotDist) {
                // 把該點移到左邊
                swap(points, l, r);
                l++;
            }
        }
        // 把最後的l位子與right交換達成分區
        swap(points, l, right);
        return l;
    }

    /**
     * 計算該點與0的距離
     */
    private int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}