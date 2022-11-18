package top.L2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.ListNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        ListNode a1 = ListNode.create(2, 4, 3);
        ListNode a2 = ListNode.create(5, 6, 4);
        ListNode a3 = ListNode.create(7, 0, 8);
        Assertions.assertEquals(solution.addTwoNumbers(a1, a2).toString(), a3.toString());
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        ListNode a1 = ListNode.create(9, 9, 9, 9, 9, 9, 9);
        ListNode a2 = ListNode.create(9, 9, 9, 9);
        ListNode a3 = ListNode.create(8, 9, 9, 9, 0, 0, 0, 1);
        Assertions.assertEquals(solution.addTwoNumbers(a1, a2).toString(), a3.toString());
    }
}