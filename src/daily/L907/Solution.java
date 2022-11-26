package daily.L907;

import java.util.Stack;

class Solution {

    private final static int MOD = 1_000_000_000 + 7;

    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[arr.length + 1];
        //預設-1為基底
        stack.push(-1);
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            //確保目前stack上為最小值index
            while (stack.peek() != -1 && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            //上個dp[stack.peek() + 1]與當前已走過之(i - stack.peek()) * arr[i]數相加
            dp[i + 1] = (dp[stack.peek() + 1] + (i - stack.peek()) * arr[i]) % MOD;
            stack.push(i);
            ans += dp[i + 1];
            ans %= MOD;
        }
        return ans;
    }
}