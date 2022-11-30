package daily.L1207;

import java.util.Arrays;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {

        int[] map = new int[2001];
        int[] cnt = new int[2001];

        Arrays.fill(cnt, -1);
        //計算cnt
        for (int i : arr) {
            if (i < 0) {
                map[i + 2000]++;
            } else {
                map[i]++;
            }
        }

        //檢查是否有重複的cnt
        for (int i : map) {
            if (cnt[i] > 0) {
                return false;
            }
            cnt[i] = i;
        }

        return true;
    }
}