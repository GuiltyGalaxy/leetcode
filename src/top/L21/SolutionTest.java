package top.L21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.ListNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        ListNode list1 = ListNode.create(1, 2, 4);
        ListNode list2 = ListNode.create(1, 3, 4);
        ListNode ans = ListNode.create(1, 1, 2, 3, 4, 4);
        Assertions.assertEquals(solution.mergeTwoLists(list1, list2).toString(), ans.toString());
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        ListNode list1 = ListNode.create();
        ListNode list2 = ListNode.create(0);
        ListNode ans = ListNode.create(0);
        Assertions.assertEquals(solution.mergeTwoLists(list1, list2).toString(), ans.toString());
    }

}