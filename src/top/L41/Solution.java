package top.L41;

class Solution {
    public int firstMissingPositive(int[] nums) {

        // 假設nums的最大值剛好為nums size-1
        // 這樣的話每個數字會有它nums[i-1]的對應位子
        // ex [3,1,2,4] => [1,2,3,4]
        // 由於我們又是找最小數
        // 所以可以不用管大數字的位子
        // 管好對應數字位子即可
        int i = 0;
        while (i < nums.length) {
            // 是否符合該位子的數字
            boolean isMatch = nums[i] == i + 1;
            // 是否為正整數
            boolean isPositive = nums[i] > 0;
            // 是否超過範圍
            boolean isOverRange = nums[i] > nums.length;
            if (isMatch || !isPositive || isOverRange) {
                i++;
            } else if (nums[nums[i] - 1] != nums[i]) {
                // 有對應數字則做swap
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        // 按照順序依序找第一個沒有對應的數字
        // 有種情況會是全部符合
        i = 0;
        while (i < nums.length && nums[i] == i + 1) {
            i++;
        }

        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}