package top.L25;

import tool.ListNode;


class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        // 往後移動k個節點
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }

        // count != k會發生在上述判斷curr == null條件先達成
        if (count == k) {
            // 繼續往下k個節點
            curr = reverseKGroup(curr, k);
            // 以當前節點開始反轉至count
            while (count-- > 0) {
                // 記錄下個節點
                ListNode tmp = head.next;
                // 把下個節點往前指到curr
                head.next = curr;
                // 移動curr到head
                curr = head;
                // head = tmp = head.next
                head = tmp;
            }
            head = curr;
        }
        return head;
    }
}