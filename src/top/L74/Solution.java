package top.L74;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;

        // 把2D當作1D運算
        int L = 0;
        int R = row * col - 1;
        // 用一般binary search
        while (L <= R) {

            int M = (L + R) / 2;
            // matrix[i][j] ==> [i * col + j]
            int val = matrix[M / col][M % col];

            if (val == target) {
                return true;
            } else if (val > target) {
                R = M - 1;
            } else {
                L = M + 1;
            }
        }

        return false;
    }
}