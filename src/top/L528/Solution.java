package top.L528;

import java.util.Random;

class Solution {

    private final Random r = new Random();
    private final int[] weight;

    public Solution(int[] w) {
        // 機率權重可以看成一個區段
        // w = 1,3,6,10
        // wSum = 1,4,10,20
        // 在wSum中使用brainy search時的機率分布就會為w的分布
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        weight = w;
    }

    public int pickIndex() {

        int last = weight[weight.length - 1];
        int idx = r.nextInt(last) + 1;

        int L = 0;
        int R = weight.length - 1;
        while (L < R) {
            int M = (L + R) / 2;
            if (weight[M] == idx) {
                return M;
            } else if (weight[M] > idx) {
                R = M;
            } else {
                L = M + 1;
            }
        }

        return L;
    }
}
