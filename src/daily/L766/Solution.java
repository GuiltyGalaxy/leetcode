package daily.L766;

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        //尋X軸
        for (int i = 0; i < matrix.length; i++) {
            if (check(matrix, i, 0, matrix[i][0])) {
                return false;
            }
        }
        //尋Y軸
        for (int i = 1; i < matrix[0].length; i++) {
            if (check(matrix, 0, i, matrix[0][i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 檢核[x,y]為起點的斜角值都為t
     */
    public boolean check(int[][] matrix, int x, int y, int t) {
        for (int i = x, j = y; i < matrix.length && j < matrix[0].length; i++, j++) {
            if (matrix[i][j] != t) {
                return true;
            }
        }
        return false;
    }
}