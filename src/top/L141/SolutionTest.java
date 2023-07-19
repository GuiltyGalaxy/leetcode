package top.L141;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.ListNode;

class SolutionTest {
    @Test
    public void case1() {
        // TODO 目前ListNode不支援有cycle的情況，測試後補
        Solution solution = new Solution();
        Assertions.assertFalse(solution.hasCycle(ListNode.create(3, 2, 0, -4)));
    }
}