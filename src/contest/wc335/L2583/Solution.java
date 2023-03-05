package contest.wc335.L2583;


import tool.TreeNode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {

        PriorityQueue<Long> queue = new PriorityQueue<>((a, b) -> -Long.compare(a, b));

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        while (!bfs.isEmpty()) {
            int size = bfs.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = bfs.poll();
                sum += cur.val;
                if (cur.left != null) {
                    bfs.offer(cur.left);
                }
                if (cur.right != null) {
                    bfs.offer(cur.right);
                }
            }
            queue.offer(sum);
        }

        //k有可能超過最大level
        if (k > queue.size()) {
            return -1;
        }

        //由於queue已經是排序的
        //按照要求取第k個即是答案
        long ans = 0;
        for (int i = 0; i < k; i++) {
            ans = queue.poll();
        }

        return ans;
    }

}