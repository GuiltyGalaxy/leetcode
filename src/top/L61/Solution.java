package top.L61;

import tool.ListNode;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 取總長度
        int len = 0;
        while (fast.next != null) {
            fast = fast.next;
            len++;
        }

        // 實際要換的長度為len - k % len
        len = len - k % len;

        // 將slow移動到切點
        for (int i = len; i > 0; i--) {
            slow = slow.next;
        }

        // 將切點分割後連接
        // 這時候的fast.next是尾巴slow.next是頭
        fast.next = dummy.next;
        dummy.next = slow.next;
        // 要斷開不然會形成圈
        slow.next = null;

        return dummy.next;
    }
}