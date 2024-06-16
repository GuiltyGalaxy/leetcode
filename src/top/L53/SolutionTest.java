package top.L53;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(6, solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(1, solution.maxSubArray(new int[]{1}));
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(23, solution.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}