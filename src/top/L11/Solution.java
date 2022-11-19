package top.L11;

class Solution {
    public int maxArea(int[] height) {
        int L = 0;
        int R = height.length - 1;
        //水量會為兩點高度取小乘長度
        int ans = Math.min(height[L], height[R]) * (R - L);

        while (L < R) {

            //哪邊高就先動另一邊
            if (height[L] <= height[R]) {
                L++;
            } else {
                R--;
            }
            ans = Math.max(Math.min(height[L], height[R]) * (R - L), ans);

        }

        return ans;
    }
}