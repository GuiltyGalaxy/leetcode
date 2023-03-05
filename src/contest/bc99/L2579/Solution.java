package contest.bc99.L2579;


class Solution {
    public long coloredCells(int n) {
        if (n == 1) {
            return 1;
        }
        //擴張速度剛好為4的等加級數
        return 4L * (n - 1) + coloredCells(n - 1);
    }
}