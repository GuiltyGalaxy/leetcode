package top.L8;

class Solution {
    public int myAtoi(String s) {

        // 去空白
        s = s.trim();
        int result = 0;
        int sign = 1;
        int len = s.length();
        int i = 0;

        // 計算首位的 + -
        if (i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '+' ? 1 : -1;
            i++;
        }

        // 設置最大INT的限制
        int maxLimit = Integer.MAX_VALUE / 10;
        int maxLimitLast = Integer.MAX_VALUE % 10;

        while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {

            // 如果result已經大於限制
            // 或是說下一位的最後一碼大於限制的最後一碼
            // 該解答只有可能為Integer.MAX_VALUE or Integer.MIN_VALUE
            if (result > maxLimit ||
                    (result == maxLimit && s.charAt(i) - '0' > maxLimitLast)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // 累加結果
            result = result * 10 + (s.charAt(i) - '0');
            i++;

        }

        return result * sign;
    }
}
