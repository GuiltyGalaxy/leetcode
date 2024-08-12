package contest.wc410.L3250;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(4, solution.countOfPairs(new int[]{2, 3, 2}));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(126, solution.countOfPairs(new int[]{5, 5, 5, 5}));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(92561040, solution.countOfPairs(new int[]{23,26,29,30,35,40,42,42,43,50}));
    }
}