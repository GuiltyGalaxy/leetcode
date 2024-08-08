package top.L84;

import java.util.ArrayDeque;

class Solution {
    public int largestRectangleArea(int[] heights) {
        // 由於Stack是線程安全，這邊使用ArrayDeque會比較快(142ms->24ms)
        ArrayDeque<Integer> s = new ArrayDeque<>();
        int n = heights.length;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            // 維持stack中的遞增性
            // 如果新的元素比top還要小
            // 則開始更新stack
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                int currPos = s.pop();
                // 移除的過程中計算面積
                // heights[currPos]為高
                // i - s.peek() - 1是底，判斷s.isEmpty()為空代表是最後一個元素，直接使用i做底
                int rect = heights[currPos] * ((s.isEmpty() ? i : (i - s.peek() - 1)));
                res = Math.max(rect, res);
            }
            s.push(i);
        }

        // 把剩餘的面積也算一算
        // 因為底不會變了所以統一用n
        while (!s.isEmpty()) {
            int tos = s.pop();
            int rect = heights[tos] * ((s.isEmpty() ? n : (n - s.peek() - 1)));
            res = Math.max(rect, res);
        }

        return res;
    }
}