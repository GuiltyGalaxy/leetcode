package top.L25;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.ListNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.reverseKGroup(ListNode.create(1, 2, 3, 4, 5), 3).toString(),
                ListNode.create(3, 2, 1, 4, 5).toString());
    }

}