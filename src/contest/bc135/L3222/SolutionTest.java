package contest.bc135.L3222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals("Alice", solution.losingPlayer(2, 7));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals("Bob", solution.losingPlayer(4, 11));
    }
}