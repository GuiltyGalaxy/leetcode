package top.L207;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.canFinish(2, new int[][]{{1, 0}}));
        Assertions.assertTrue(solution.canFinish2(2, new int[][]{{1, 0}}));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        Assertions.assertFalse(solution.canFinish2(2, new int[][]{{1, 0}, {0, 1}}));
    }
}