package top.L22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertIterableEquals(solution.generateParenthesis(3), Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"));
    }

}