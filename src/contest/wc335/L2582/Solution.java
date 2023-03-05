package contest.wc335.L2582;

class Solution {
    public int passThePillow(int n, int time) {
        int idx = 1;
        int dir = 1;
        while (time != 0) {
            idx += dir;
            if (idx == 1) {
                dir = 1;
            } else if (idx == n) {
                dir = -1;
            }
            time--;
        }
        return idx;
    }
}