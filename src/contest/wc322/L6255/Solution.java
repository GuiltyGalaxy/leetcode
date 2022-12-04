package contest.wc322.L6255;


import java.util.Arrays;

class Solution {
    int[] dsu;

    public int minScore(int n, int[][] roads) {
        //使用union find
        dsu = new int[n + 1];
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dsu[i] = i;
        }
        Arrays.fill(ans, Integer.MAX_VALUE);

        for (int[] r : roads) {
            //尋找root節點
            int a = find(r[0]);
            int b = find(r[1]);
            //合併節點
            dsu[a] = dsu[b];
            //紀錄ans
            ans[a] = ans[b] = Math.min(r[2], Math.min(ans[a], ans[b]));
        }
        //答案會是1的root ans
        return ans[find(1)];
    }

    int find(int i) {
        return dsu[i] == i ? i : (dsu[i] = find(dsu[i]));
    }
}