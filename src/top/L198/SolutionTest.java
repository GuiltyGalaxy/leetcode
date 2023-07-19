package top.L198;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.rob(new int[]{1, 2, 3, 1}), 4);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.rob(new int[]{2, 7, 9, 3, 1}), 12);
    }
}