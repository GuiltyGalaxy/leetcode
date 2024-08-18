package contest.wc411.L3258;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(12, solution.countKConstraintSubstrings("10101", 1));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(25, solution.countKConstraintSubstrings("1010101", 2));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(15, solution.countKConstraintSubstrings("11111", 1));
    }
}