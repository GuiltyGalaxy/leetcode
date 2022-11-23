package top.L74;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;

        //把2D當作1D運算
        int i = 0, j = row * col - 1;
        //用一般binary search
        while (i <= j) {

            int mid = (i + j) / 2;
            // matrix[i][j] ==> [i * col + j]
            int val = matrix[mid / col][mid % col];

            if (val == target) {
                return true;
            } else if (val > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return false;
    }
}