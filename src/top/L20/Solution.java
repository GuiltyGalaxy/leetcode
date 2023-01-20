package top.L20;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char cp = stack.pop();
                if (c == ')' && cp == '(') {
                    continue;
                }
                if (c == ']' && cp == '[') {
                    continue;
                }
                if (c == '}' && cp == '{') {
                    continue;
                }
                return false;
            }
        }
        return stack.isEmpty();
    }
}