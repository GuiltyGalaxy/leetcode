package top.L121;

class Solution {
    public int maxProfit(int[] prices) {
        int lowPrice = Integer.MAX_VALUE;
        int ans = 0;
        for (int price : prices) {
            //更新最低價格
            if (price < lowPrice) {
                lowPrice = price;
            }
            //獲利比先前高就更新
            if (price - lowPrice > ans) {
                ans = price - lowPrice;
            }
        }
        return ans;
    }
}