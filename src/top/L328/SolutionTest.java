package top.L328;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.ListNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.oddEvenList(ListNode.create(1, 2, 3, 4, 5)).toString()
                , ListNode.create(1, 3, 5, 2, 4).toString());
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.oddEvenList(ListNode.create(2, 1, 3, 5, 6, 4, 7)).toString()
                , ListNode.create(2, 3, 6, 7, 1, 5, 4).toString());
    }
}