package top.L503;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>();
        //循環所以長度要算到n*2
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            //更新next成stack中最大值
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                next[stack.pop()] = num;
            }
            //還在數組中則把該值放進stack
            if (i < n) {
                stack.push(i);
            }
        }
        return next;
    }
}