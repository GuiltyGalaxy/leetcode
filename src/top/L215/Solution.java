package top.L215;


import java.util.Random;

class Solution {
    private static final Random random = new Random();

    /**
     * 平均O(n) 選擇排序
     */
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }

        int pivotIndex = left + random.nextInt(right - left + 1);
        pivotIndex = partition(nums, left, right, pivotIndex);

        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }

        swap(nums, storeIndex, right);
        return storeIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * 取巧方式
     */
    public int findKthLargest2(int[] nums, int k) {
        // 由於題目有數字範圍，所以建立一個array來存放所有數字出現次數
        int[] counter = new int[20_001];
        // 統計出現次數
        for (int num : nums) {
            counter[num + 10_000]++;
        }

        int cnt = 0;
        // 從最小的值開始計算出現次數，當大於k就是解答了
        for (int i = counter.length - 1; i >= 0; i--) {
            cnt += counter[i];
            if (cnt >= k) {
                return i - 10_000;
            }
        }
        return -1;
    }
}