package daily.L223;

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        //計算兩區域
        int area1 = Math.abs(ax1 - ax2) * Math.abs(ay1 - ay2);
        int area2 = Math.abs(bx1 - bx2) * Math.abs(by1 - by2);
        //計算重疊
        int x = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int y = Math.min(ay2, by2) - Math.max(ay1, by1);

        int repeat = 0;
        //其中一數為負代表沒重疊
        if (x > 0 && y > 0) {
            repeat = x * y;
        }
        //兩區域相加後減去重疊面積就為總面積
        return area1 + area2 - repeat;
    }
}