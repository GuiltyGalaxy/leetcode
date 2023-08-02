package top.L394;

import java.util.Stack;

class Solution {
    private int idx = 0;

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                // 遇到']'開始處理
                StringBuilder curr = new StringBuilder();
                // 把[]之間的char都加到sb中
                while (!stack.peek().equals("[")) {
                    curr.insert(0, stack.pop());
                }
                // 移除'['
                stack.pop();
                // 處理'['前面的數字
                StringBuilder num = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    num.insert(0, stack.pop());
                }
                int n = Integer.parseInt(num.toString());
                // 將本次處理結果塞回
                stack.push(curr.toString().repeat(n));
            } else {
                stack.push(String.valueOf(s.charAt(i)));
            }
        }

        // 將stack內容轉換成res
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }

        return res.toString();
    }

    // 遞歸解法
    public String decodeString2(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx++);
            if (c == '[') {
                // 處理[]
                String temp = decodeString2(s);
                // 最後處理結果依照'['前數字repeat
                sb.append(temp.repeat(count));
                count = 0;
            } else if (c == ']') {
                break;
            } else if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}