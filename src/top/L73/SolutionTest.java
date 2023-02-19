package top.L73;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        int[][] ans = new int[][]{
                {1, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 0, 5}
        };
        solution.setZeroes(ans);
        Assertions.assertArrayEquals(ans, new int[][]{
                {0, 0, 0, 0},
                {3, 4, 0, 0},
                {0, 0, 0, 0}
        });
    }

}