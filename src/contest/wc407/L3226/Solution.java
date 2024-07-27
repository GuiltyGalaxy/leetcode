package contest.wc407.L3226;


class Solution {
    public int minChanges(int n, int k) {

        if (n == k) {
            return 0;
        }

        int ans = 0;
        while (n > 0 || k > 0) {
            // 只能將1變成0，所以遇到1 0一定會不同直接返回
            if((k & 1) == 1 && (n & 1) == 0){
                return -1;
            }
            // 不同則增加1次變動次數
            if ((n & 1) != (k & 1)) {
                ans++;
            }
            n >>= 1;
            k >>= 1;
        }
        return ans;
    }
}