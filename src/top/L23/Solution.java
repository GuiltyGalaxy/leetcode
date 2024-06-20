package top.L23;

import tool.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    /**
     * O(N log k) 使用PriorityQueue
     */
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        // 串建一個幽靈節點
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;


        while (!minHeap.isEmpty()) {

            ListNode minNode = minHeap.poll();

            current.next = minNode;
            // 移動節點
            current = current.next;

            // 如果該節點的下個節點還有值則加入堆中繼續處理
            if (minNode.next != null) {
                minHeap.add(minNode.next);
            }
        }

        // 利用幽靈節點輕易取得原先的頭
        return dummy.next;
    }

    /**
     * O(N log k)合併排序，比較快是因為少了PriorityQueue的堆處理，所以會快一些，時間複雜度是相同的
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        // 處離長度剩1就不在分了
        if (start == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;
        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);

        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // 合併排序
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // 把剩下多餘的接到後續
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }

}