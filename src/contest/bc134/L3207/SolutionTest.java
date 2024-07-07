package contest.bc134.L3207;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(3, solution.maximumPoints(new int[]{3, 2, 2}, 2));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(5, solution.maximumPoints(new int[]{2}, 10));
    }

}