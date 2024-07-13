package top.L994;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(4, solution.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(-1, solution.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(0, solution.orangesRotting(new int[][]{{0, 2}}));
    }
}