package contest.wc406.L3217;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.ListNode;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        ListNode in = ListNode.create(1, 2, 3, 4, 5);
        ListNode ans = ListNode.create(4, 5);
        Assertions.assertEquals(ans.toString(), solution.modifiedList(new int[]{1, 2, 3}, in).toString());
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        ListNode in = ListNode.create(1, 2, 1, 2, 1, 2);
        ListNode ans = ListNode.create(2, 2, 2);
        Assertions.assertEquals(ans.toString(), solution.modifiedList(new int[]{1}, in).toString());
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        ListNode in = ListNode.create(1, 2, 3, 4);
        ListNode ans = ListNode.create(1, 2, 3, 4);
        Assertions.assertEquals(ans.toString(), solution.modifiedList(new int[]{5}, in).toString());
    }

    @Test
    void case4() {
        Solution solution = new Solution();
        ListNode in = ListNode.create(9, 10, 2);
        ListNode ans = ListNode.create(10);
        Assertions.assertEquals(ans.toString(), solution.modifiedList(new int[]{9, 2}, in).toString());
    }
}