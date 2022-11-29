package top.L846;

import java.util.Arrays;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);

        for (int i = 0; i < hand.length; i++) {

            if (hand[i] == -1) {
                continue;
            }

            if (!helper(hand, groupSize, i, 0, hand[i])) {
                return false;
            }
        }

        return true;
    }

    /**
     * 遞迴方式尋找group
     *
     * @param index            目前index
     * @param currentGroupSize 當前group長度
     * @param nextNum          尋找數字
     */
    private boolean helper(int[] hand, int groupSize, int index, int currentGroupSize, int nextNum) {

        //符合目標長度
        if (currentGroupSize == groupSize) {
            return true;
        }

        //找到底了
        if (hand.length == index) {
            return false;
        }

        //找到對應數字
        if (nextNum == hand[index]) {
            currentGroupSize++;
            nextNum++;
            //標記成已找過
            hand[index] = -1;
        }

        return helper(hand, groupSize, index + 1, currentGroupSize, nextNum);
    }
}