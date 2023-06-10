package top.L210;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(solution.findOrder(2, new int[][]{{1, 0}}), new int[]{0, 1});
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(
                solution.findOrder(4
                        , new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})
                , new int[]{0, 1, 2, 3});
    }
}