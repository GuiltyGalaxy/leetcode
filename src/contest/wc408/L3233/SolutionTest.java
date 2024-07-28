package contest.wc408.L3233;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(3, solution.nonSpecialCount(5, 7));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(11, solution.nonSpecialCount(4, 16));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(53012, solution.nonSpecialCount(5630, 58673));
    }
}