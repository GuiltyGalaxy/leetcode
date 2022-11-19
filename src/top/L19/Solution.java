package top.L19;

import tool.ListNode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //做個假head
        ListNode tmp = new ListNode(0, head);
        ListNode left = tmp;
        ListNode right = head;

        //right比left先提前n個點
        while (n-- > 0) {
            right = right.next;
        }

        //right==null時left就會剛好在要移除的前一點
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        //透過置換next達到移除功能
        left.next = left.next.next;
        return tmp.next;
    }
}