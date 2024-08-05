package contest.bc136.L3238;


class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        int res = 0;
        int[][] players = new int[n][11];
        boolean[] isWin = new boolean[n];
        for (int[] p : pick) {
            // players[p[0]][p[1]] > p[0]持球數要大於玩家編號才算贏
            // seen[p[0]]是否已贏過
            if (++players[p[0]][p[1]] > p[0] && !isWin[p[0]]) {
                res++;
                isWin[p[0]] = true;
            }
        }
        return res;
    }
}