package top.L136;

class Solution {

    public int singleNumber(int[] nums) {
        // 同個數被XOR會變0，利用這特性找出沒有成對的數字
        int res = 0;
        for (int num :nums) {
            res ^= num;
        }
        return res;
    }
}