package top.L61;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.ListNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.rotateRight(ListNode.create(1, 2, 3, 4, 5), 2).toString(),
                ListNode.create(4, 5, 1, 2, 3).toString());
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.rotateRight(ListNode.create(0, 1, 2), 4).toString(),
                ListNode.create(2, 0, 1).toString());
    }

}