package top.L542;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}, solution.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        Assertions.assertArrayEquals(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}, solution.updateMatrix2(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 2, 1}}, solution.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}));
        Assertions.assertArrayEquals(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 2, 1}}, solution.updateMatrix2(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}));
    }
}