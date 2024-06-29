package top.L525;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    /**
     * 使用map紀錄 O(n)
     */
    public int findMaxLength(int[] nums) {
        // 用一個map紀錄總和與index的關連
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        // 初始化總和0的起始位子為-1
        // 因要記錄起始位子
        prefixSumMap.put(0, -1);

        int maxLength = 0;
        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {

            // 0當做-1
            prefixSum += nums[i] == 0 ? -1 : 1;

            // 如果該prefixSum有存在於map中
            // 代表有平衡子數組
            if (prefixSumMap.containsKey(prefixSum)) {
                // 將紀錄的起始位子取出做計算
                int length = i - prefixSumMap.get(prefixSum);
                // 比較當前最大長度
                maxLength = Math.max(maxLength, length);
            } else {
                // 紀錄該總和的位子
                prefixSumMap.put(prefixSum, i);
            }
        }

        return maxLength;
    }

    /**
     * 使用array取代map O(n)，實際上會比map快一些，少了map的操作
     */
    public int findMaxLength2(int[] nums) {
        int n = nums.length;
        // 用一個兩倍長度的array來記錄num可能的情況
        // 為什麼使用兩倍是因為假設全部為0或全部為1的紀錄可能性
        int[] arr = new int[2 * n + 1];
        // -2代表沒紀錄過
        Arrays.fill(arr, -2);
        int sum = n;
        int max = 0;

        // n是起始點紀錄為-1
        // 因應可能有數組的起始點就是開始位子
        arr[n] = -1;

        for (int i = 0; i < n; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (arr[sum] == -2) {
                // 遇到沒紀錄過的則記錄
                arr[sum] = i;
            } else {
                // 以記錄過就代表有平衡子數組存在
                // 計算長度
                max = Math.max(max, i - arr[sum]);
            }
        }
        return max;
    }
}
