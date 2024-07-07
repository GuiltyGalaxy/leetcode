package contest.bc134.L3206;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(0, solution.numberOfAlternatingGroups(new int[]{1, 1, 1}));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(3, solution.numberOfAlternatingGroups(new int[]{0, 1, 0, 0, 1}));
    }
}