package top.L48;

class Solution {
    public void rotate(int[][] matrix) {
        // 先以斜角翻轉再以直軸翻轉即可得到右旋圖型
        // 以1->9為軸線做對稱翻轉(也就是159這條線)
        // 1 2 3     1 4 7
        // 4 5 6  => 2 5 8
        // 7 8 9     3 6 9
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 以4->6為軸線做對稱翻轉(也就是456這條線)
        // 1 4 7    7 4 1
        // 2 5 8 => 8 5 2
        // 3 6 9    9 6 3
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}