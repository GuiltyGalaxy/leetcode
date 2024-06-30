package contest.wc404.L3202;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(5, solution.maximumLength(new int[]{1, 2, 3, 4, 5}, 2));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(4, solution.maximumLength(new int[]{1, 4, 2, 3, 1, 4}, 3));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(3, solution.maximumLength(new int[]{1, 2, 3, 10, 2}, 6));
    }
}