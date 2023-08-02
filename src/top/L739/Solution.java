package top.L739;

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            // 遇到本日溫度大於stack的top
            // 開始計算天數
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // 計算過的天數移除
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        int max = Integer.MIN_VALUE;
        // 從最後一天開始推算
        for (int i = n - 1; i >= 0; i--) {
            // 遇到比max還大做更新
            if (temperatures[i] >= max) {
                max = temperatures[i];
                continue;
            }
            // 跑到這裡代表前幾天有一天溫度比今天大
            // 先預設是前一天
            int days = 1;
            // 開始往前推算
            while (temperatures[i + days] <= temperatures[i]) {
                // 直接使用res來利用之前的結果推算差多少天
                // 巧妙地避免掉要推算到實際天數的時間複雜度
                // O(n)寫法為 days++;
                // O(1)
                days += res[i + days];
            }
            res[i] = days;
        }
        return res;
    }
}