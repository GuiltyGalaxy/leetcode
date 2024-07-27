package contest.wc407.L3229;


class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        var n = nums.length;
        // 利用兩個參數去記錄目前為遞增或遞減狀態
        long incr = 0;
        long decr = 0;
        long ops = 0;

        // 由於我們可以一次將整個群組往上或往下
        // 02320 => 01210
        // 所以可以得出只要計算這個群組最高的差異量
        // 就可得出該群組所需歸零的移動次數
        for (var i = 0; i < n; i++) {
            var diff = target[i] - nums[i];

            // 判斷差異是往正向還負向
            if (diff > 0) {
                // 如果正向高度目前低於差異
                // 則操作次數需加上diff與incr差
                if (incr < diff) {
                    ops += diff - incr;
                }
                incr = diff;
                decr = 0;
            } else if (diff < 0) {
                // 反之亦然
                if (diff < decr) {
                    ops += decr - diff;
                }
                decr = diff;
                incr = 0;
            } else {
                incr = 0;
                decr = 0;
            }
        }

        return ops;
    }
}
