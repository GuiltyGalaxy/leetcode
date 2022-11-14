package top.L150;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.evalRPN(new String[]{"2", "1", "+", "3", "*"}), 9);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.evalRPN(new String[]{"4", "13", "5", "/", "+"}), 6);
    }
}