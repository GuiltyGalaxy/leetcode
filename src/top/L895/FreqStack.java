package top.L895;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class FreqStack {
    // 紀錄數字出現次數
    private final HashMap<Integer, Integer> freqMap;
    // 紀錄相同次數下數字出現順序
    private final List<Stack<Integer>> stack;

    public FreqStack() {
        freqMap = new HashMap<>();
        stack = new ArrayList<>();
        stack.add(new Stack<>());
    }

    public void push(int x) {
        // 更新次數
        int freq = freqMap.getOrDefault(x, 0) + 1;
        freqMap.put(x, freq);
        // size不夠則新增
        if (freq == stack.size()) {
            stack.add(new Stack<>());
        }
        // 把對次數的數字新增上去
        stack.get(freq).add(x);
    }

    public int pop() {
        // 取次數出現最多的數字
        Stack<Integer> top = stack.get(stack.size() - 1);
        int x = top.pop();
        // 取完代表說該頻率沒東西了
        if (top.size() == 0) {
            stack.remove(stack.size() - 1);
        }
        // 更新數字對應次數
        freqMap.put(x, freqMap.get(x) - 1);
        return x;
    }
}