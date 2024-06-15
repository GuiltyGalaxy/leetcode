package top.L55;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.canJump(new int[]{2, 3, 1, 1, 4}));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}