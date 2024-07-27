package contest.bc135.L3222;


class Solution {
    public String losingPlayer(int x, int y) {
        // 目標為115
        // x Value = 75
        // y Value = 10
        // 可以知道如果要拿到目標一定要 x + 4y
        // 由此可推論如果最低遊戲局數為偶數
        // 就一定是Alice
        // 比較x與y/4的數字可得知最低遊戲次數
        int turns = Math.min(x, y / 4);
        return (turns % 2 == 1) ? "Alice" : "Bob";
    }
}