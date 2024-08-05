package contest.bc136.L3238;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(0, solution.winningPlayerCount(5, new int[][]{
                {1, 1}, {1, 2}, {1, 3}, {1, 4}
        }));
    }

}