package contest.bc99.L2580;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.countWays(new int[][]{{1, 3}, {10, 20}, {2, 5}, {4, 8}}), 4);
    }

}