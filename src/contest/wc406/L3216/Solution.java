package contest.wc406.L3216;

import java.util.Arrays;

class Solution {
    public String getSmallestString(String s) {

        char[] cs = s.toCharArray();
        // 排序後就為最小字典則不異動
        Arrays.sort(cs);
        if (new String(cs).equals(s)) {
            return s;
        }


        for (int i = 0; i < s.length() - 1; i++) {
            // 只要連續為odd或even就試著前後對調，只要前面數字比較大就可
            if (isOdd(s.charAt(i)) == isOdd(s.charAt(i + 1)) && s.charAt(i) > s.charAt(i + 1)) {
                char[] arr = s.toCharArray();
                swap(arr, i, i + 1);
                return new String(arr);
            }
        }
        return s;
    }

    void swap(char[] cs, int x, int y) {
        char tmp = cs[x];
        cs[x] = cs[y];
        cs[y] = tmp;
    }

    boolean isOdd(char c) {
        return (c - '0') % 2 == 0;
    }
}