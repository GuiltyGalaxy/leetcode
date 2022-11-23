package top.L528;

import java.util.Random;

class Solution {

    Random r = new Random();
    int[] wSum;

    public Solution(int[] w) {
        //機率權重可以看成一個區段
        // w = 1,3,6,10
        // wSum = 1,4,10,20
        //在wSum中使用brainy search時的機率分布就會為w的分布
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        wSum = w;
    }

    public int pickIndex() {

        int idx = r.nextInt(wSum[wSum.length - 1]) + 1;

        int L = 0;
        int R = wSum.length - 1;
        while (L < R) {
            int M = (L + R) / 2;
            if (wSum[M] == idx) {
                return M;
            } else if (wSum[M] > idx) {
                R = M;
            } else {
                L = M + 1;
            }
        }

        return L;
    }
}
