package top.L67;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals("100", solution.addBinary("11", "1"));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals("10101", solution.addBinary("1010", "1011"));
    }
}