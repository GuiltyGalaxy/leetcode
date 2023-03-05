package contest.bc99.L2580;


import java.util.Arrays;

class Solution {
    public int countWays(int[][] ranges) {
        int ans = 1;
        int last = -1;
        int mod = (int) 1e9 + 7;
        //按照起始排序
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        for (int[] r : ranges) {
            //下個排序起點大於上個排序終點代表新的群組
            if (last < r[0]) {
                //答案是群組個數的2平方
                ans = ans * 2 % mod;
            }
            //更新當前終點
            last = Math.max(last, r[1]);
        }
        return ans;
    }
}