package top.L92;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.ListNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(
                solution.reverseBetween(ListNode.create(1, 2, 3, 4, 5), 2, 4).toString(),
                ListNode.create(1, 4, 3, 2, 5).toString());
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(
                solution.reverseBetween(ListNode.create(5), 1, 1).toString(),
                ListNode.create(5).toString());
    }
}