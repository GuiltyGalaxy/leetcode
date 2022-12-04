package wc322.L6254;

import java.util.Arrays;

class Solution {
    public long dividePlayers(int[] skill) {

        Arrays.sort(skill);

        long ans = 0;

        int prev = 0;
        int L = 0;
        int R = skill.length - 1;
        //排序過後的情況下
        // skill[0] + skill[n-1] == skill[1] + skill[n-2]
        while (L < R) {

            int sum = skill[L] + skill[R];
            int m = skill[L] * skill[R];
            //不符合前個sum直接跳出
            if (prev != 0 && prev != sum) {
                return -1;
            }
            prev = sum;
            ans += m;
            L++;
            R--;
        }

        return ans;
    }
}