package top.L148;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.ListNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        ListNode in = ListNode.create(4, 2, 1, 3);
        ListNode ans = ListNode.create(1, 2, 3, 4);
        Assertions.assertEquals(solution.sortList(in).toString(), ans.toString());
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        ListNode in = ListNode.create(-1, 5, 3, 4, 0);
        ListNode ans = ListNode.create(-1, 0, 3, 4, 5);
        Assertions.assertEquals(solution.sortList(in).toString(), ans.toString());
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        ListNode in = ListNode.create();
        ListNode ans = ListNode.create();
        Assertions.assertEquals(solution.sortList(in), ans);
    }
}