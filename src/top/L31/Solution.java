package top.L31;

public class Solution {

    // 詳細說明https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
    public void nextPermutation(int[] nums) {
        int index = indexOfLastPeak(nums) - 1;
        if (index != -1) {
            int nextIndex = lastIndexOfGreater(nums, nums[index]);
            // 找到兩個對應點數字互換
            swap(nums, index, nextIndex);
        }
        // 將換至前面數字後面的全部數字反轉
        reverseSuffix(nums, index + 1);
    }

    /**
     * 從後面開始找升序排列結束點
     * ex.
     * 1 2 7 6 5 4 3 1
     * ←←←←*←←←←←←←←←←
     * 結束點為7
     */
    private int indexOfLastPeak(int[] nums) {
        for (int i = nums.length - 1; 0 < i; i--) {
            if (nums[i - 1] < nums[i]) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 從後面開始找第一個大於target的數字
     * ex. target = 2
     * 1 2 7 6 5 4 3 1
     * return 3(index)
     */
    private int lastIndexOfGreater(int[] nums, int target) {
        for (int i = nums.length - 1; 0 <= i; i--) {
            if (target < nums[i]) {
                return i;
            }
        }
        return -1;
    }

    private void reverseSuffix(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}