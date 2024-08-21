package top.L152;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(6, solution.maxProduct(new int[]{2, 3, -2, 4}));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(0, solution.maxProduct(new int[]{-2, 0, -1}));
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(-2, solution.maxProduct(new int[]{-2}));
    }
}