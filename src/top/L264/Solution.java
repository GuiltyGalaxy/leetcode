package top.L264;

class Solution {
    public int nthUglyNumber(int n) {

        int[] ugly = new int[n];
        ugly[0] = 1;
        // (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
        // (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
        // (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int factor2 = 2;
        int factor3 = 3;
        int factor5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            //依照最小值符合的數去更新
            if (factor2 == min)
                factor2 = 2 * ugly[++index2];
            if (factor3 == min)
                factor3 = 3 * ugly[++index3];
            if (factor5 == min)
                factor5 = 5 * ugly[++index5];
        }
        return ugly[n - 1];
    }
}