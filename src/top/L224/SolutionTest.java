package top.L224;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.calculate("1 + 1"), 2);
        Assertions.assertEquals(solution.calculate2("1 + 1"), 2);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.calculate(" 2-1 + 2 "), 3);
        Assertions.assertEquals(solution.calculate2(" 2-1 + 2 "), 3);
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.calculate("(1+(4+5+2)-3)+(6+8)"), 23);
        Assertions.assertEquals(solution.calculate2("(1+(4+5+2)-3)+(6+8)"), 23);
    }
}