package top.L32;

import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        // stack裡面只會放'('
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int left = -1;
        for (int i = 0; i < s.length(); i++) {

            // 起頭一定要從'('開始
            if (s.charAt(i) == '(') {
                stack.push(i);
                continue;
            }

            // 如是')'但stack沒有人配對
            // 則更新left
            if (stack.isEmpty()) {
                left = i;
                continue;
            }

            stack.pop();
            if (stack.isEmpty()) {
                // 配完了直接取i - left
                max = Math.max(max, i - left);
            } else {
                // i - stack.peek()為當前配對成功的最大值
                max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }

    // 不使用stack解法
    public int longestValidParentheses2(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;

        // 從頭開始計算
        for (int i = 0; i < s.length(); i++) {
            // 累加'(' ')'次數
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            // 如果次數相等代表一定有符合條件
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            }

            // 由於是從頭開始
            // 所以只有'('能當作起點
            // right只要大於left就直接清空重算
            if (right > left) {
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;

        // 從尾巴開始計算
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            }

            if (left > right) {
                left = 0;
                right = 0;
            }
        }

        return maxLen;
    }
}