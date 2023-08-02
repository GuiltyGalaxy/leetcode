package top.L227;

class Solution {

    // 紀錄先前一次加減結果
    private int preSum = 0;
    // 記錄最後一個數字，拿來先乘除後加減用
    private int lastNum = 0;

    public int calculate(String s) {

        char sign = '+';
        int num = 0;

        for (char c : s.toCharArray()) {
            // 空白跳過
            if (c == ' ') {
                continue;
            }

            // 數字則計算至num
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
                continue;
            }

            // 符號處理
            calculateSign(sign, num);
            // 重新計算num
            num = 0;
            // 紀錄最後一次的符號
            sign = c;
        }

        // 進行最後處理
        calculateSign(sign, num);

        return preSum + lastNum;
    }

    /**
     * 依照符號進行數字處理
     */
    private void calculateSign(char sign, int num) {
        switch (sign) {
            case '+' -> {
                preSum += lastNum;
                lastNum = num;
            }
            case '-' -> {
                preSum += lastNum;
                lastNum = -num;
            }
            case '*' -> lastNum *= num;
            case '/' -> lastNum /= num;
        }
    }
}