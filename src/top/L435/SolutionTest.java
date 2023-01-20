package top.L435;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}), 1);
        Assertions.assertEquals(solution.eraseOverlapIntervals2(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}), 1);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}), 2);
        Assertions.assertEquals(solution.eraseOverlapIntervals2(new int[][]{{1, 2}, {1, 2}, {1, 2}}), 2);
    }
}