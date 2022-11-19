package top.L29;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.divide(10, 3), 3);
        Assertions.assertEquals(solution.divide(7, -3), -2);
        Assertions.assertEquals(solution.divide(-2147483648, -1), 2147483647);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.divide(7, -3), -2);
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.divide(-2147483648, -1), 2147483647);
    }

}