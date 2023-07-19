package top.L21;

import tool.ListNode;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 != null && list2 != null) {
            // 每次比較兩節點較大值續接
            // 由於會把list1.next帶入下一次遞歸
            // 剛好省去存放list1.next的必要
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }

        return list1 == null ? list2 : list1;
    }
}