package leetcode.L1047;

import java.util.Stack;

class Solution {
    public String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            //stack有相鄰字母則移除
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        //stack是反著放入，要反著組合string
        char[] c = new char[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            c[i] = stack.pop();
        }
        return new String(c);
    }
}