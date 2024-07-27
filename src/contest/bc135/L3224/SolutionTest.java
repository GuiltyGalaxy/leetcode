package contest.bc135.L3224;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(2, solution.minChanges(new int[]{1, 0, 1, 2, 4, 3}, 4));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(2, solution.minChanges(new int[]{0, 1, 2, 3, 3, 6, 5, 4}, 6));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(5, solution.minChanges(new int[]{7, 0, 3, 7, 3, 10, 2, 11, 7, 8, 7, 5}, 14));
    }


    @Test
    void case4() {
        Solution solution = new Solution();
        Assertions.assertEquals(7, solution.minChanges(new int[]{1, 1, 1, 1, 0, 0, 0, 5, 4, 3, 19, 17, 16, 15, 15, 15, 19, 19, 19, 19}, 20));
    }
}