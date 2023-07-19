package top.L143;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.ListNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        ListNode in = ListNode.create(1, 2, 3, 4);
        ListNode ans = ListNode.create(1, 4, 2, 3);
        solution.reorderList(in);
        Assertions.assertEquals(in.toString(), ans.toString());
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        ListNode in = ListNode.create(1, 2, 3, 4, 5);
        ListNode ans = ListNode.create(1, 5, 2, 4, 3);
        solution.reorderList(in);
        Assertions.assertEquals(in.toString(), ans.toString());
    }

}