package contest.bc134.L3208;


class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        // 新建置一個array，以便計算最後一個為起點
        // 如果k=3，那最後一個情況為[n] [0] [1]，所以新增的長度為k - 1
        int[] extendedColors = new int[n + k - 1];
        System.arraycopy(colors, 0, extendedColors, 0, n);
        System.arraycopy(colors, 0, extendedColors, n, k - 1);
        int ans = 0;
        int cnt = 1;
        for (int i = 1; i < extendedColors.length; ++i) {
            if (extendedColors[i] != extendedColors[i - 1]) {
                // 當不同時增加長度
                cnt++;
            } else {
                // 遇到相同的從新計算長度
                cnt = 1;
            }
            // 數量比k大代表符合
            if (cnt >= k) {
                ans++;
            }
        }
        return ans;
    }
}