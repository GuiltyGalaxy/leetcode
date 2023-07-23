package top.L347;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        if (k == nums.length) {
            return nums;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        // 找出上下邊界
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        // 建立數字出現頻率
        int[] freq = new int[max - min + 1];
        for (int num : nums) {
            freq[num - min]++;
        }
        // 將頻率相同的數字放進bucket
        List<Integer>[] bucket = new List[nums.length + 1];
        // 紀錄出現最多次的次數
        int max_freq = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                if (bucket[freq[i]] == null) {
                    bucket[freq[i]] = new ArrayList<>();
                }
                // 由於範圍有被調整過，要把min做為基底加回去
                bucket[freq[i]].add(i + min);
                max_freq = Math.max(max_freq, freq[i]);
            }
        }
        // 將bucket依照所要求的k數量放進res
        int[] res = new int[k];
        int i = 0;
        // 從最高頻率的數字開始
        for (int j = max_freq; j >= 0 && i < k; j--) {
            if (bucket[j] != null) {
                // 頻率相同的數字全部提取
                for (int num : bucket[j]) {
                    if (i == k) {
                        // 超過k則提前結束
                        break;
                    }
                    res[i++] = num;
                }
            }
        }
        return res;
    }
}