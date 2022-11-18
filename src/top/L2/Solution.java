package top.L2;

import tool.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //前面插入一個空node比較好算
        ListNode ans = new ListNode();
        ListNode tmp = ans;
        int crray = 0;
        while (l1 != null || l2 != null) {

            int val_1 = 0;
            if (l1 != null) {
                val_1 = l1.val;
                l1 = l1.next;
            }
            int val_2 = 0;
            if (l2 != null) {
                val_2 = l2.val;
                l2 = l2.next;
            }

            int sum = val_1 + val_2 + crray;
            crray = sum / 10;
            sum %= 10;
            ans.next = new ListNode(sum);
            ans = ans.next;
        }

        if (crray == 1) {
            ans.next = new ListNode(1);
        }

        //跳過空node
        return tmp.next;
    }
}