package contest.wc407.L3229;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(2, solution.minimumOperations(new int[]{3, 5, 1, 2}, new int[]{4, 6, 2, 4}));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(5, solution.minimumOperations(new int[]{1, 3, 2}, new int[]{2, 1, 4}));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(5, solution.minimumOperations(new int[]{1, 1, 3, 4}, new int[]{4, 1, 3, 2}));
    }
}