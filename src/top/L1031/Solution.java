package top.L1031;

class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] prefixSums = new int[nums.length];
        prefixSums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i];
        }

        //firstLen與secondLen位子可能互換，所以要算兩種情況的結果
        int max1 = findMaxSum(prefixSums, firstLen, secondLen);
        int max2 = findMaxSum(prefixSums, secondLen, firstLen);

        return Math.max(max1, max2);
    }

    private int findMaxSum(int[] prefixSums, int firstLen, int secondLen) {
        int globalMax = prefixSums[firstLen + secondLen - 1];
        int max1 = prefixSums[firstLen - 1];
        for (int i = 0; i < prefixSums.length - firstLen - secondLen; i++) {
            int sum1 = prefixSums[i + firstLen] - prefixSums[i];
            int sum2 = prefixSums[i + firstLen + secondLen] - prefixSums[i + firstLen];
            //紀錄firstLen最大sum1
            max1 = Math.max(max1, sum1);
            //紀錄secondLen最大sum2
            //並直接與max1相加形成globalMax
            globalMax = Math.max(globalMax, max1 + sum2);
        }
        return globalMax;
    }
}