package top.L7;

class Solution {
    public int reverse(int x) {
        int prevRev = 0;
        int res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            // 利用反推(res - x % 10) / 10是否等同於prevRev
            // 驗證是否超出範圍
            if ((res - x % 10) / 10 != prevRev) {
                return 0;
            }
            prevRev = res;
            x = x / 10;
        }
        return res;
    }
}