package top.L148;

import tool.ListNode;

class Solution {
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // 利用快慢point達到對分效果
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 斷開slow與fast的連結
        pre.next = null;

        // 合併排序
        return merge(sortList(head), sortList(slow));
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode res = new ListNode(-1);
        ListNode resHead = res;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                res.next = a;
                a = a.next;
            } else {
                res.next = b;
                b = b.next;
            }
            res = res.next;
        }

        if (a != null) {
            res.next = a;
        }
        if (b != null) {
            res.next = b;
        }

        return resHead.next;
    }
}