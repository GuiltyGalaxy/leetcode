package contest.wc407.L3226;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(2, solution.minChanges(13, 4));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(0, solution.minChanges(21, 21));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(-1, solution.minChanges(14, 13));
    }

    @Test
    void case4() {
        Solution solution = new Solution();
        Assertions.assertEquals(-1, solution.minChanges(11, 56));
    }

}