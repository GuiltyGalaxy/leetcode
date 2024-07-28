package contest.wc408.L3233;


import java.util.Arrays;

class Solution {
    public int nonSpecialCount(int l, int r) {
        // 將最大數開根號，當作等等質數搜索範圍
        int lim = (int) Math.sqrt(r);

        // 使用刪去法去計算所有質數
        boolean[] isPrime = new boolean[lim + 1];
        // 假設全部都是
        Arrays.fill(isPrime, true);
        // 0 1例外先設定成false
        isPrime[0] = isPrime[1] = false;

        // 使用Eratosthenes
        // 利用刪去法算出範圍內質數
        for (int i = 2; i * i <= lim; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= lim; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 計算題目所要求的special number不是單純質數
        // 因為他的因數有扣除自己
        // 例如 4 -> 1 2 4但4不算，所以剩下1 2
        // 所以可得出一個特性
        // 就是special number一定為質數平方
        // Ex. 2-4 3-9 5-25 7-49
        int specialCount = 0;
        for (int i = 2; i <= lim; i++) {
            if (isPrime[i]) {
                int square = i * i;
                // 平方在範圍內則累加
                if (square >= l && square <= r) {
                    specialCount++;
                }
            }
        }

        int totalCount = r - l + 1;
        // 全部減去specialCount就為答案
        return totalCount - specialCount;
    }
}