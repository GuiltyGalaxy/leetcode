package top.L261;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
        Assertions.assertTrue(solution.validTree2(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
        Assertions.assertTrue(solution.validTree3(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
        Assertions.assertFalse(solution.validTree2(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
        Assertions.assertFalse(solution.validTree3(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
    }
}