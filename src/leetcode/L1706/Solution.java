package leetcode.L1706;

class Solution {

    static int ROW_MAX = 0;
    static int COL_MAX = 0;

    public int[] findBall(int[][] grid) {

        ROW_MAX = grid.length;
        COL_MAX = grid[0].length;
        int[] ans = new int[COL_MAX];

        //從右到左依序丟球
        for (int i = 0; i < COL_MAX; i++) {
            ans[i] = i;
            //從上到下開始判斷
            for (int j = 0; j < ROW_MAX; j++) {
                int d = check(grid, j, ans[i]);
                //沒路時將該結果設成-1
                if (d == 0) {
                    ans[i] = -1;
                    break;
                }
                //更新當前位子
                ans[i] += d;
            }
        }

        return ans;
    }

    /**
     * 檢查[r,c]往下走的結果
     *
     * @return <p>
     * -1 : 向左 <p>
     * 0  : 沒路 <p>
     * 1  : 向右 <p>
     */
    public int check(int[][] grid, int r, int c) {

        int dst = grid[r][c];
        boolean touch_r = dst == 1 && c == COL_MAX - 1;
        boolean touch_l = dst == -1 && c == 0;
        //判斷是否碰壁
        if (touch_r || touch_l) {
            return 0;
        }

        //向右時右邊的方向也要相同
        if (dst == 1 && grid[r][c + 1] == 1) {
            return 1;
        }

        //向左時左邊的方向也要相同
        if (dst == -1 && grid[r][c - 1] == -1) {
            return -1;
        }

        return 0;
    }
}