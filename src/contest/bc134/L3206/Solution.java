package contest.bc134.L3206;


class Solution {
    public int numberOfAlternatingGroups(int[] colors) {

        int ans = 0;
        int n = colors.length;
        // 由於長度為3，所以會計算到前後一個
        // 處理後一個
        if (colors[0] != colors[n - 1] && colors[0] != colors[1]) {
            ans++;
        }

        // 處理前一個
        if (colors[n - 1] != colors[0] && colors[n - 1] != colors[n - 2]) {
            ans++;
        }

        // 剩下的依序判定，只要color不等於相鄰兩邊即可
        for (int i = 1; i < n - 1; i++) {
            int color = colors[i];
            if (colors[i - 1] != color && colors[i + 1] != color) {
                ans++;
            }
        }

        return ans;
    }
}