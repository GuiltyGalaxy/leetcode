package contest.bc99.L2579;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.coloredCells(2), 5);
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.coloredCells(3), 13);
    }

}