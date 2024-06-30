package contest.wc404.L3201;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(4, solution.maximumLength(new int[]{1, 2, 3, 4}));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(6, solution.maximumLength(new int[]{1, 2, 1, 1, 2, 1, 2}));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(2, solution.maximumLength(new int[]{1, 3}));
    }
}