package top.L134;

class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int total = 0;
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            int cur = gas[i] - cost[i];
            total += cur;
            sum += cur;
            if (sum < 0) {
                //該起點無法走完則以當前位子下個點當作起點
                start = i + 1;
                sum = 0;
            }
        }
        //total<0 則代表不管哪個點都不夠
        return total < 0 ? -1 : start;
    }

}