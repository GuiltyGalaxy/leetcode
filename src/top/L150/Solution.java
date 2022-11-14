package top.L150;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                //遇到符號則把當前stack最上面兩個數字拿出來運算並add至stack
                int b = stack.pop();
                int a = stack.pop();
                switch (s) {
                    case "+" -> stack.add(a + b);
                    case "-" -> stack.add(a - b);
                    case "*" -> stack.add(a * b);
                    default -> stack.add(a / b);
                }
            } else {
                //數字直接add至stack
                stack.add(Integer.valueOf(s));
            }
        }
        //最後會剩一個數字就為答案
        return stack.peek();
    }
}