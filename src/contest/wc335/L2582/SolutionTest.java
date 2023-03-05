package contest.wc335.L2582;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.passThePillow(4, 5), 2);
    }
}