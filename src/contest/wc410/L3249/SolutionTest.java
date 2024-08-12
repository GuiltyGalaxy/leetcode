package contest.wc410.L3249;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();

        Assertions.assertEquals(6, solution.countGoodNodes(
                new int[][]{{6, 0}, {1, 0}, {5, 1}, {2, 5}, {3, 1}, {4, 3}}
        ));
    }

}