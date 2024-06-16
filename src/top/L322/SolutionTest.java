package top.L322;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(3, solution.coinChange(new int[]{1, 2, 5}, 11));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(-1, solution.coinChange(new int[]{2}, 3));
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(0, solution.coinChange(new int[]{1}, 0));
    }
}