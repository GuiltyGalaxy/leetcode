package top.L875;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        // 因最快數度吃完就是每小時可吃一顆樹
        // 故計算範圍為最大香蕉串
        int L = 1;
        int R = 0;
        for (int pile : piles) {
            R = Math.max(R, pile);
        }

        // 開始計算最小需要幾小時吃完
        while (L < R) {

            int eatSpeed = (R + L) / 2;

            // 計算以目前的的速度吃是否吃得完
            int hoursNeeded = 0;
            for (int pile : piles) {
                // pile - 1是為了避免剛好吃完會多+1小時
                hoursNeeded += (pile - 1) / eatSpeed;
                // 每吃完一棵要休息一小時
                hoursNeeded += 1;
            }
            // 依照試算結果決定要加速還減速
            if (hoursNeeded >= h) {
                R = eatSpeed;
            } else {
                L = eatSpeed + 1;
            }
        }
        // 最後L為最小吃完速度
        return L;
    }

}