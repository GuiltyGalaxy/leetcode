package top.L658;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    /**
     * O(log n) + O(k log k) binary search
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> result = new ArrayList<>();

        // 找到離 x 最近的元素位置
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // 設置雙指針
        int low = right - 1;
        int high = right;

        // 使用雙指針找到最近的 k 個元素
        while (k > 0) {
            if (low < 0 || (high < arr.length && Math.abs(arr[high] - x) < Math.abs(arr[low] - x))) {
                result.add(arr[high]);
                high++;
            } else {
                result.add(arr[low]);
                low--;
            }
            k--;
        }

        Collections.sort(result);
        return result;
    }

    /**
     * O(n) 滑動窗口
     */
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {

        int left = 0;
        int right = arr.length - 1;

        // 不斷比較left right，找到大小為 k 的窗口
        while (right - left >= k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        // 收集結果
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        return result;
    }


}