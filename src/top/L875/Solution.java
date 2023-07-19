package top.L875;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int l = 1;
        int r = 1000000000;
        // 使用binary search逼近
        while (l < r) {

            int eatSpeed = (l + r) / 2;
            int totalHours = 0;

            // 計算以該eatSpeed吃完所有香蕉的時間
            // 加上eatSpeed - 1當作基底(因除數是eatSpeed)
            // -1的目的是避免出現剛好吃完的情況會多1h
            // 舉例
            // eatSpeed=4
            // pile=3,h=1
            // pile=4,h=1(這邊沒-1會變成h=2)
            // pile=5,h=2
            for (int pile : piles) {
                totalHours += (pile + eatSpeed - 1) / eatSpeed;
            }

            // 依結果決定向哪邊逼近
            if (totalHours > h) {
                l = eatSpeed + 1;
            } else {
                r = eatSpeed;
            }
        }
        return l;
    }
}