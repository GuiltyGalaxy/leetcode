package top.L42;

class Solution {
    public int trap(int[] height) {
        // 使用two pointer解法
        // 從最左最右往中間逼近
        // 利用currHeight來判定向哪邊逼近(因較高的點一定是不動的)
        // 在逼近過程中比較前一次高度
        // 不斷計算累積量
        int L = 0;
        int R = height.length - 1;
        int sum = 0;
        int currHeight = Math.max(height[R], height[L]);
        int lh = 0;
        int rh = 0;
        while (L < R) {
            // 當前最高值比右邊大
            if (height[R] < currHeight) {
                rh = Math.max(rh, height[R]);
                R--;
                // 代表有積水產生，累加sum
                if (height[R] < rh) {
                    sum += rh - height[R];
                }
            } else if (height[L] <= currHeight) {
                // 同理
                lh = Math.max(lh, height[L]);
                L++;
                if (height[L] < lh) {
                    sum += lh - height[L];
                }
            }
            // 更新目前最高高度
            currHeight = Math.max(height[R], height[L]);
        }
        return sum;
    }
}