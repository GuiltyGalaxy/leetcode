package top.L876;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.ListNode;

class SolutionTest {

    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(
                solution.middleNode(ListNode.create(1, 2, 3, 4, 5)).toString()
                , ListNode.create(3, 4, 5).toString());
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(
                solution.middleNode(ListNode.create(1, 2, 3, 4, 5, 6)).toString()
                , ListNode.create(4, 5, 6).toString());
    }
}