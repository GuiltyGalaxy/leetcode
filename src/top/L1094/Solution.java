package top.L1094;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] stops = new int[1001];
        //建立區段
        for (int[] t : trips) {
            stops[t[1]] += t[0];
            stops[t[2]] -= t[0];
        }
        for (int stop : stops) {
            capacity -= stop;
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }
}