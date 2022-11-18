package daily.L263;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.isUgly(0));
        Assertions.assertTrue(solution.isUgly(1));
        Assertions.assertTrue(solution.isUgly(6));
        Assertions.assertFalse(solution.isUgly(14));
        Assertions.assertFalse(solution.isUgly(-1));
        Assertions.assertFalse(solution.isUgly(-2));
    }
}