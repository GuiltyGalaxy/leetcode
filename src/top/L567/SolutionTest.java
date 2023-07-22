package top.L567;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.checkInclusion("ab", "eidbaooo"));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.checkInclusion("ab", "eidboaoo"));
    }
}