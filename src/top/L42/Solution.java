package top.L42;

class Solution {
    public int trap(int[] height) {
        /*
          使用two pointer解法
          從最左最右往中間逼近
          利用currHeight來判定向哪邊逼近(因較高的點一定是不動的)
          在逼近過程中比較前一次高度
          不斷計算累積量
         */
        int left = 0;
        int rigth = height.length - 1;
        int sum = 0;
        int currHeight = Math.max(height[rigth], height[left]);
        int lh = 0;
        int rh = 0;
        while (left < rigth) {
            // 當前最高值比右邊大
            if (height[rigth] < currHeight) {
                // 更新rh
                rh = Math.max(rh, height[rigth]);
                // 位移指標
                rigth--;
                // 代表有積水產生，累加sum
                if (height[rigth] < rh) {
                    sum += rh - height[rigth];
                }
            } else if (height[left] <= currHeight) {
                // 同理
                lh = Math.max(lh, height[left]);
                left++;
                if (height[left] < lh) {
                    sum += lh - height[left];
                }
            }
            // 更新目前最高高度
            currHeight = Math.max(height[rigth], height[left]);
        }
        return sum;
    }
}