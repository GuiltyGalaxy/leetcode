package top.L155;

import java.util.Stack;

class MinStack {
    Stack<Node> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        int newMin;
        // 由於Stack特性
        // 只需紀錄目前最小值於該Node內
        // 就可確保該值為當強Stack最小值
        if (stack.size() == 0) {
            newMin = val;
        } else {
            int currentMin = stack.peek().min;
            newMin = Math.min(val, currentMin);
        }
        stack.push(new Node(val, newMin));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }

    /**
     * 紀錄當前的數值與最小值狀態
     */
    private static class Node {
        int val;
        int min;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
}