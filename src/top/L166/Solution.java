package top.L166;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private Map<Long, Integer> map = new HashMap<>();

    public String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        //紀錄sign
        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append("-");
        }

        //轉換long並用正整數算
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        sb.append(num / den);

        if (num % den != 0) {
            sb.append('.');
        }

        util(num % den, den, sb);

        return sb.toString();
    }

    private void util(long num, long den, StringBuilder sb) {

        //餘數為0就不再算了
        if (num == 0) {
            return;
        }

        //重複餘數出現
        //因一樣的數除相同的除數結果一定相同，由此判斷後面開始循環小數
        if (map.containsKey(num)) {
            //從該餘數最後出現位子()起來
            sb.insert(map.get(num), "(");
            sb.append(')');
            return;
        }

        //紀錄該餘數的位子
        map.put(num, sb.length());
        num *= 10;

        long div = num / den;
        sb.append(div);

        util(num % den, den, sb);
    }
}