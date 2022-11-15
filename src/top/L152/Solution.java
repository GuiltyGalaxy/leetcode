package top.L152;

class Solution {
    /**
     * 最大連續數組的乘積一定為從頭到尾(在沒有0或負數的情況下)
     * 1.有負數的情況下只要是偶數負數就一樣不會變，由此我們可以重頭尾開始不斷計算看誰數字比較高
     * 2.遇到0的情況就從新計算，把0當做一個斷點，不管從哪邊開始遇到0都會為0，所以當作新的數組開始
     */
    public int maxProduct(int[] nums) {
        //紀錄頭尾目前乘積
        int r = 0;
        int l = 0;
        //預設答案為第一個數
        //因[-2],ans = -2
        int ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            //乘積為0代表上個數遇到0，則替換成1從新開始
            l = (l == 0 ? 1 : l) * nums[i];
            r = (r == 0 ? 1 : r) * nums[nums.length - i - 1];
            ans = Math.max(ans, Math.max(l, r));
        }
        return ans;
    }
}