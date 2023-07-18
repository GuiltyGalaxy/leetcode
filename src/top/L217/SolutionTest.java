package top.L217;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.containsDuplicate(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }
}