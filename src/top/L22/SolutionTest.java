package top.L22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertIterableEquals(solution.generateParenthesis(3),
                List.of(
                        "((()))",
                        "(()())",
                        "(())()",
                        "()(())",
                        "()()()"
                ));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertIterableEquals(solution.generateParenthesis(1), List.of("()"));
    }
}