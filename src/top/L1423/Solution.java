package top.L1423;

class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int len = cardPoints.length;
        int leftsum = 0;
        int rightsum = 0;
        int ans = 0;
        //預設先選最左邊的card
        for (int i = 0; i < k; i++) {
            leftsum += cardPoints[i];
        }

        ans = leftsum;
        //不斷向右端偏移
        for (int i = 0; i < k; i++) {
            leftsum -= cardPoints[k - 1 - i];
            rightsum += cardPoints[len - 1 - i];
            ans = Math.max(ans, leftsum + rightsum);
        }

        return ans;
    }
}