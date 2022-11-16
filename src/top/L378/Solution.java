package top.L378;

class Solution {


    //O(n*log(max-min))
    //於序列矩陣中找目標值
    //參考:https://anj910.medium.com/leetcode-378-kth-smallest-element-in-a-sorted-matrix-%E4%B8%AD%E6%96%87-318d52f366af
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        //由於序列矩陣特性
        // 0,0一定是最小值
        // n-1,n-1一定是最大值
        int start = matrix[0][0];
        int end = matrix[n - 1][n - 1];
        while (start < end) {
            //假設一個中間值
            //因只是要找第k個元數，所以不用找到真的數字
            int mid = start + (end - start) / 2;
            int rank = helper(matrix, mid);
            if (rank < k) {
                //找到的數量不足代表mid不夠大，將mid往右偏移
                start = mid + 1;
            } else {
                //找到數量過多代表mid太大，將mid往左偏移
                end = mid;
            }
        }
        return start;
    }

    /**
     * 依照target去找出matrix中有幾個數比他小
     *
     * @return 比target小的數有多少
     */
    private int helper(int[][] matrix, int target) {
        int n = matrix.length;
        int y = n - 1;
        int x = 0;
        int count = 0;
        while (y >= 0 && x < n) {
            if (matrix[y][x] <= target) {
                //要+y的意義在於，如果目前在[3][0]
                //就代表[2][0]、[1][0]、[0][0]都小於這個數
                //所以就不再特別找，直接跳過往[3][1]去找
                count += (y + 1);
                x++;
            } else {
                y--;
            }
        }
        return count;
    }

    //O(N*k)
    public int kthSmallest2(int[][] matrix, int k) {

        //找到第幾個
        int cnt = 0;
        int ans = 0;
        int n = matrix.length;
        //記錄每一行的index到哪了
        int[] index = new int[n];

        while (cnt < k) {
            int min = Integer.MAX_VALUE;
            int idx = 0;
            //循序歷遍
            for (int i = 0; i < n; i++) {
                if (index[i] < n && matrix[i][index[i]] <= min) {
                    min = matrix[i][index[i]];
                    idx = i;
                }
            }
            ans = min;
            index[idx]++;
            cnt++;
        }
        return ans;
    }
}