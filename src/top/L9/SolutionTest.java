package top.L9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.isPalindrome(121));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.isPalindrome(-121));
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.isPalindrome(1234554321));
    }
}