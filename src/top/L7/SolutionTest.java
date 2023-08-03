package top.L7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.reverse(123), 321);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.reverse(-123), -321);
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.reverse(120), 21);
    }

    @Test
    public void case4() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.reverse(Integer.MAX_VALUE), 0);
    }
}