package top.L733;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(
                solution.floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2),
                new int[][]{{2, 2, 2}, {2, 2, 0}, {2, 0, 1}});
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(
                solution.floodFill(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0, 0, 2),
                new int[][]{{2, 2, 2}, {2, 2, 2}});
    }
}