package top.L1094;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5));
    }
}