package top.L76;

class Solution {
    public String minWindow(String s, String t) {

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        // 計算t每個字母出現次數
        int[] freq = new int[128];
        for (char c : tArr) {
            freq[c]++;
        }

        int L = 0;
        int R = 0;
        // 紀錄最小字串起始位子
        int startIndex = 0;
        int size = Integer.MAX_VALUE;
        int cnt = tArr.length;
        // 維護一個window，其中滿足所有t都包含在其中，並且是最短的window
        while (R < sArr.length) {
            // 更新freq，如果是在t中的--後會為0
            if (freq[sArr[R]]-- > 0) {
                cnt--;
            }
            R++;
            // 滿足條件開使推算L
            while (cnt == 0) {
                if (R - L < size) {
                    size = R - L;
                    startIndex = L;
                }
                // 遇到freq回正代表移除的L在t中，把cnt加回
                if (freq[sArr[L]]++ == 0) {
                    cnt++;
                }
                L++;
            }
        }

        // 都沒有的情況
        if (size == Integer.MAX_VALUE) {
            return "";
        }

        // 最後再把字串拚出來，如果計算中就拚會浪費一些時間
        return s.substring(startIndex, startIndex + size);
    }
}