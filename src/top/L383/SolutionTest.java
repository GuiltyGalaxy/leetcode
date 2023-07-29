package top.L383;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.canConstruct("a", "b"));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.canConstruct("aa", "aab"));
    }
}