package contest.bc136.L3239;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(2, solution.minFlips(new int[][]{
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        }));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(1, solution.minFlips(new int[][]{
                {0, 1},
                {0, 1},
                {0, 0}
        }));
    }

}