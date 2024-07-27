package contest.wc407.L3227;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.doesAliceWin("leetcoder"));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.doesAliceWin("bbcd"));
    }
}