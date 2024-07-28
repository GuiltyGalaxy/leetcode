package contest.wc408.L3232;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.canAliceWin(new int[]{1, 2, 3, 4, 10}));
    }


    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.canAliceWin(new int[]{1, 2, 3, 4, 5, 14}));
    }
}