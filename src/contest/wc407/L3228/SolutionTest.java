package contest.wc407.L3228;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(4, solution.maxOperations("1001101"));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(0, solution.maxOperations("00111"));
    }
}