package contest.wc409.L3242;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        NeighborSum neighborSum = new NeighborSum(new int[][]{
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        });
        Assertions.assertEquals(6, neighborSum.adjacentSum(1));
        Assertions.assertEquals(16, neighborSum.adjacentSum(4));
        Assertions.assertEquals(16, neighborSum.diagonalSum(4));
        Assertions.assertEquals(4, neighborSum.diagonalSum(8));
    }

}