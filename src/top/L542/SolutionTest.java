package top.L542;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(solution.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}), new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(solution.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}), new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 2, 1}});
    }
}