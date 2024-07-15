package contest.wc406.L3217;


import tool.ListNode;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        // 在最前方加入dummy方便計算
        ListNode dummy = new ListNode();
        ListNode prv = dummy;
        while (head != null) {
            // 只要不在移除的選項中則加入
            if (!set.contains(head.val)) {
                prv.next = head;
                prv = prv.next;
            }
            head = head.next;
        }
        // 收尾
        prv.next = null;
        return dummy.next;
    }
}