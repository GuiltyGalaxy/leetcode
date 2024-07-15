package contest.wc406.L3219;

import java.util.Arrays;

class Solution {

    /**
     * 題目同上一題，但有增大範圍並限制Memory，所以要用另一種方式去計算
     */
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        // 按照大小排序
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        // 由Cost多的開始，所以從後面開始計算
        int i = horizontalCut.length - 1;
        int j = verticalCut.length - 1;
        // 紀錄目前h v已經被切幾刀了
        int hc = 1;
        int vc = 1;
        long ans = 0;
        while (i >= 0 || j >= 0) {
            // 切cost比較多的，所以horizontalCut[i] < verticalCut[j]
            if (j >= 0 && (i < 0 || horizontalCut[i] < verticalCut[j])) {
                // 要注意切v的方向要去算hc的次數，而不是vc，因水平切不會影響到要多切的刀數
                ans += (long) hc * verticalCut[j--];
                vc++;
            } else {
                ans += (long) vc * horizontalCut[i--];
                hc++;
            }
        }
        return ans;
    }
}
