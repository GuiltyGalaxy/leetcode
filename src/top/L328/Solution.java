package top.L328;

import tool.ListNode;

class Solution {
    public ListNode oddEvenList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        // even會先到尾巴所以用它來判定是否結束
        while (even != null && even.next != null) {
            // 每個指針都往後跳2格
            odd.next = odd.next.next;
            even.next = even.next.next;
            // 設完之後往下
            odd = odd.next;
            even = even.next;
        }
        // 最後串起來
        odd.next = evenHead;

        return head;
    }
}