package top.L125;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.isPalindrome(" "));
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.isPalindrome("race a car"));
    }
}