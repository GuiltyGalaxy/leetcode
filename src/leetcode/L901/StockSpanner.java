package leetcode.L901;

import java.util.Stack;

class StockSpanner {

    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int res = 1;
        //持續收斂stack
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            res += stack.pop()[1];
        }
        //將本次累計結果紀錄
        stack.push(new int[]{price, res});
        return res;
    }
}