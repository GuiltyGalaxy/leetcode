package top.L143;

import tool.ListNode;

class Solution {

    public void reorderList(ListNode head) {
        // 先找中間點
        ListNode mid = mid(head);
        ListNode midNext = mid.next;
        mid.next = null;

        ListNode p1 = head;
        // 從中間點反轉
        ListNode p2 = rev(midNext);

        ListNode temp;

        // 交叉插入
        while (p1 != null && p2 != null) {
            temp = p1.next;
            p1.next = p2;
            p1 = p2;
            p2 = temp;
        }
    }


    private ListNode mid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode rev(ListNode head) {
        ListNode next;
        ListNode prev = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}