package top.L23;

import tool.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        // 優先順序為list的head最小的擺最前面
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // 把每個list的head加進queue
        Arrays.stream(lists)
                .filter(Objects::nonNull)
                .forEach(queue::add);

        while (!queue.isEmpty()) {
            // 由於有排過所以拿出來的一定會是最小值
            tail.next = queue.poll();
            // 往下一個
            tail = tail.next;

            // 還有下一個則把它放回queue中
            if (tail.next != null) {
                queue.add(tail.next);
            }
        }

        return dummy.next;
    }
}