package top.L323;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(2, solution.countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}}));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(1, solution.countComponents(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}));
    }

}