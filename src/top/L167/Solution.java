package top.L167;

class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int low = 0;
        int hi = numbers.length - 1;

        while (low < hi) {
            int sum = numbers[low] + numbers[hi];
            if (sum == target) {
                break;
            } else if (sum < target) {
                low++;
            } else {
                hi--;
            }
        }

        return new int[]{low + 1, hi + 1};
    }
}