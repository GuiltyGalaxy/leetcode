package top.L8;

class Solution {
    public int myAtoi(String str) {

        str = str.trim();
        int len = str.length();

        if (len == 0) {
            return 0;
        }

        int index = 0;

        //記錄正負
        char ch;
        boolean isNegative = (ch = str.charAt(index)) == '-';
        if (isNegative || ch == '+') {
            ++index;
        }

        //去掉尾數的最大值設為overflow門檻
        int maxLimit = Integer.MAX_VALUE / 10;
        int result = 0;
        while (index < len && isDigit(ch = str.charAt(index))) {

            int digit = ch - '0';

            //當計算到最後一位大於7代表該數一定為MAX or MIN
            if (result > maxLimit || (result == maxLimit && digit > 7)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = (result * 10) + digit;

            index++;
        }

        return isNegative ? -result : result;
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
