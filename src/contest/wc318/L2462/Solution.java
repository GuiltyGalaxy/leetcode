package contest.wc318.L2462;

import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {

        int left = 0;
        int right = costs.length - 1;
        //小的在前面
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> costs[a] == costs[b] ? a - b : costs[a] - costs[b]);

        //先將候選人圈起
        //會圈出前後各一組
        while (left < candidates) {
            queue.add(left++);
        }

        //圈後面這組有限制
        // r >= costs.length - candidates
        // r >= l
        // 這兩條件都是避免重複圈選
        while (right >= costs.length - candidates && right >= left) {
            queue.add(right--);
        }

        long total = 0;

        while (k-- > 0) {
            int current = queue.poll();
            total += costs[current];

            //重新圈選候選人
            //這時就沒有重複條件限制問題
            //left就向右再取一個
            //right就向左再取一個
            if (current < left && left <= right) {
                queue.add(left++);
            } else if (current > right && right >= left) {
                queue.add(right--);
            }
        }

        return total;
    }
}