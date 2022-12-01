package daily.L1704;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.halvesAreAlike("book"));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.halvesAreAlike("textbook"));
    }

}