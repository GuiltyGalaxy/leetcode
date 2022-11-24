package top.L23;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.ListNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        ListNode[] list = new ListNode[3];
        list[0] = ListNode.create(1, 4, 5);
        list[1] = ListNode.create(1, 3, 4);
        list[2] = ListNode.create(2, 6);
        Assertions.assertEquals(solution.mergeKLists(list).toString(), ListNode.create(1, 1, 2, 3, 4, 4, 5, 6).toString());
    }

}