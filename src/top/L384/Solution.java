package top.L384;

import java.util.Random;

class Solution {

    int[] org;
    int[] array;
    Random random;

    public Solution(int[] nums) {
        org = nums;
        array = org.clone();
        random = new Random();
    }

    public int[] reset() {
        return org;
    }

    public int[] shuffle() {
        int cur = 0;
        int len = array.length;
        while (cur < len) {
            //以cur為基底隨機替換位子
            int ranIndex = random.nextInt(len - cur) + cur;
            int tmp = array[cur];
            array[cur] = array[ranIndex];
            array[ranIndex] = tmp;
            cur++;
        }
        return array;
    }
}