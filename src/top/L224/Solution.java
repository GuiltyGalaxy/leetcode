package top.L224;

import java.util.Stack;

class Solution {

    private int idx = 0;

    // 使用stack的解法
    public int calculate(String s) {

        int res = 0;
        int sign = 1;
        int currentNumber = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(sign);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                currentNumber = currentNumber * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                res += sign * currentNumber;
                // 有種情況為--得+
                // 其他都沒影響
                sign = stack.peek() * (c == '+' ? 1 : -1);
                currentNumber = 0;
            } else if (c == '(') {
                // 紀錄'('前sign為何
                stack.push(sign);
            } else if (c == ')') {
                // 使用完成移除
                stack.pop();
            }
        }

        res += sign * currentNumber;
        return res;
    }

    // 使用遞歸解法
    public int calculate2(String s) {
        return cal(s);
    }

    private int cal(String s) {
        int res = 0;
        int num = 0;
        int sign = 1;
        while (idx < s.length()) {
            char c = s.charAt(idx++);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '(') {
                // 遇到'('其實就代表新的一個計算結果
                // 以該idx繼續往下算
                num = cal(s);
            } else if (c == ')') {
                // 回傳本次()結果
                return res + sign * num;
            } else if (c == '+' || c == '-') {
                res += sign * num;
                num = 0;
                sign = c == '-' ? -1 : 1;
            }
        }
        return res + sign * num;
    }
}