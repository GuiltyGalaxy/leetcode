package top.L29;

class Solution {

    public int divide(int dividend, int divisor) {

        //edge case
        if (dividend == -2147483648 && divisor == -1) {
            return 2147483647;
        }

        int ans = 0;
        int sign = dividend > 0 == divisor > 0 ? 1 : -1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if (dividend == divisor) {
            return sign;
        }

        for (int i = 0, val = divisor; dividend - divisor >= 0; i = 0, val = divisor) {
            //每次要除之前先不斷對divisor加倍<<i
            //以加快for的速度
            while (val > 0 && dividend - val >= 0) {
                val = divisor << ++i;
            }
            //回正++的數
            i--;
            dividend -= divisor << i;
            ans += 1 << i;
        }

        return sign * ans;
    }
}