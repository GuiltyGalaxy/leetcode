package contest.wc404.L3200;

class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        // 先排紅與先排藍都算一遍，取最大
        return Math.max(maxHeight(red, blue), maxHeight(blue, red));
    }

    private int maxHeight(int a1, int a2) {
        int h = 0;
        int i = 1;

        while (true) {
            if (i % 2 == 1) {
                if (a1 >= i) {
                    a1 -= i;
                } else {
                    break;
                }
            } else {
                if (a2 >= i) {
                    a2 -= i;
                } else {
                    break;
                }
            }
            h++;
            i++;
        }

        return h;
    }
}