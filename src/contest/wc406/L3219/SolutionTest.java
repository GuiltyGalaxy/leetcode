package contest.wc406.L3219;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(13, solution.minimumCost(3, 2, new int[]{1, 3}, new int[]{5}));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(15, solution.minimumCost(2, 2, new int[]{7}, new int[]{4}));
    }

}