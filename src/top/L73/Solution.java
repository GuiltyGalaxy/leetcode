package top.L73;

public class Solution {
    public void setZeroes(int[][] matrix) {

        //是否有0出現在起始列
        boolean isZeroRow = false;
        boolean isZeroCol = false;
        //將起始列當作暫存器
        //因m[i][j] == 0時
        //對應 matrix[0][j] matrix[i][0]一定也為0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) isZeroRow = true;
                    if (j == 0) isZeroCol = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //將剛剛紀錄的結果反映到所有ROW COL
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //最後處理起始列
        if (isZeroRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (isZeroCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}