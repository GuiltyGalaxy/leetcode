package contest.bc99.L2578;

import java.util.Arrays;

class Solution {
    public int splitNum(int num) {

        char[] numArray = String.valueOf(num).toCharArray();
        Arrays.sort(numArray);

        int n1 = 0;
        int n2 = 0;

        //最小數會是排序後輪流取號
        int cnt = 0;
        for (char c : numArray) {
            if (cnt % 2 == 0) {
                n1 *= 10;
                n1 += c - '0';
            } else {
                n2 *= 10;
                n2 += c - '0';
            }
            cnt++;
        }

        return n1 + n2;
    }
}