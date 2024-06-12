package top.L136;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(1, solution.singleNumber(new int[]{2, 2, 1}));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(4, solution.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(1, solution.singleNumber(new int[]{1}));
    }
}