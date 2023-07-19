package top.L141;

import tool.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        // 使用2 pointer檢測是否有循環
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 有循環的話pointer一定會有撞到的時候
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}