package top.L234;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.ListNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.isPalindrome(ListNode.create(1, 2, 2, 1)));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.isPalindrome(ListNode.create(1, 2)));
    }

}