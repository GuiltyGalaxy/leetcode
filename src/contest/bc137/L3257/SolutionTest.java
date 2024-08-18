package contest.bc137.L3257;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(4, solution.maximumValueSum(new int[][]{
                {-3, 1, 1, 1},
                {-3, 1, -3, 1},
                {-3, 2, 1, 1}
        }));
    }

}