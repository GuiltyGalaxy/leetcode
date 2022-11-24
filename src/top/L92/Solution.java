package top.L92;


import tool.ListNode;

public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //先將node位移至left位子
        ListNode cur1 = dummy;
        ListNode pre1 = null;
        for(int i=0;i<left;i++){
            pre1 = cur1;
            cur1 = cur1.next;
        }

        //從該位子開始反轉
        ListNode cur2 = cur1;
        ListNode pre2 = pre1;
        ListNode next;
        for(int i=left;i<=right;i++){
            next = cur2.next;
            cur2.next = pre2;
            pre2 = cur2;
            cur2 = next;
        }

        //將頭尾接起
        pre1.next = pre2;
        cur1.next = cur2;

        return dummy.next;
    }
}