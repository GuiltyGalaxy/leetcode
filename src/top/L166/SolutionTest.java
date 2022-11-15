package top.L166;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.fractionToDecimal(1, 2), "0.5");
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.fractionToDecimal(2, 1), "2");
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.fractionToDecimal(4, 333), "0.(012)");
    }

    @Test
    public void case4() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.fractionToDecimal(-1, -2147483648),
                "0.0000000004656612873077392578125");
    }
}