package contest.bc99.L2578;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.splitNum(4325), 59);
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.splitNum(687), 75);
    }
}