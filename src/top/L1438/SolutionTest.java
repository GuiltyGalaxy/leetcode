package top.L1438;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.longestSubarray(new int[]{8, 2, 4, 7}, 4), 2);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5), 4);
    }

}