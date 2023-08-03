package top.L50;

class Solution {
    public double myPow(double x, int n) {
        double res = helper(x, Math.abs((long) n));
        // 原先次方數是負的要倒數
        if ((long) n < 0) {
            return 1 / res;
        }
        return res;
    }

    private double helper(double num, long pow) {
        if (pow == 0) {
            return 1;
        }
        // ex.
        // 2^9 = 2 2 2 2 2 2 2 2 2
        // => 4 4 4 4 2
        // => 16 16 2
        double temp = helper(num, pow / 2);
        temp = temp * temp;

        if (pow % 2 == 0) {
            return temp;
        } else {
            // 非2的倍數要補上少的那一次
            return temp * num;
        }
    }
}