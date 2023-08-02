package top.L32;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.longestValidParentheses("(()"), 2);
        Assertions.assertEquals(solution.longestValidParentheses2("(()"), 2);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.longestValidParentheses(")()())"), 4);
        Assertions.assertEquals(solution.longestValidParentheses2(")()())"), 4);
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.longestValidParentheses(""), 0);
        Assertions.assertEquals(solution.longestValidParentheses2(""), 0);
    }

}