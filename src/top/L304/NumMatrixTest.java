package top.L304;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumMatrixTest {
    @Test
    public void case1() {
        NumMatrix numMatrix = new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        });
        Assertions.assertEquals(numMatrix.sumRegion(2, 1, 4, 3), 8);
        Assertions.assertEquals(numMatrix.sumRegion(1, 1, 2, 2), 11);
        Assertions.assertEquals(numMatrix.sumRegion(1, 2, 2, 4), 12);
    }
}