package leetcode.L1544;

import java.util.Stack;

class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            //大小寫差距剛好為32
            //檢查stack最上層是否為可消除
            if (!stack.empty() && Math.abs(c - stack.peek()) == 32) {
                //大小寫字母互相消除
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        char[] c = new char[stack.size()];
        //stack取出順序會顛倒，所以從c.length - 1開始
        for (int i = c.length - 1; i >= 0; i--) {
            c[i] = stack.pop();
        }
        return new String(c);
    }
}