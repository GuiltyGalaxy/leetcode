package top.L48;

class Solution {
    public void rotate(int[][] matrix) {
        /*
         * 1 2 3     7 8 9
         * 4 5 6  => 4 5 6
         * 7 8 9     1 2 3
         */
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        /*
         * 7 8 9     7 4 1
         * 4 5 6  => 8 5 2
         * 1 2 3     9 6 3
         */
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}