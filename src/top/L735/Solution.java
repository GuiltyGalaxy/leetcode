package top.L735;

import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            if (a > 0) {
                stack.push(a);
            } else {
                // 遇到負方向星球開始處理撞擊結果
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(a)) {
                    // 撞擊到比自己小且方向不同的的直接移除
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0) {
                    // 前個星球是同方向則存活
                    stack.push(a);
                } else if (stack.peek() + a == 0) {
                    // 遇到相同大小兩個星球都消失
                    stack.pop();
                }
            }
        }

        // 將結果轉換成int[]
        int[] ans = new int[stack.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }

        return ans;
    }
}
