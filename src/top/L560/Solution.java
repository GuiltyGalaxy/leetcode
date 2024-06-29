package top.L560;

import java.util.HashMap;

class Solution {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 初始化0為一個子數組
        map.put(0, 1);

        int count = 0;
        int sum = 0;

        for (int num : nums) {

            // 由於有要求一定要為連續子數組，所以可以直接利用累加的方式去計算
            sum += num;
            // sum - k有對應的子數組代表有符合的
            if (map.containsKey(sum - k)) {
                // 把該子數組數量加上
                count += map.get(sum - k);
            }
            // 將該總和放置於map中，如果已存在代表有2個數組以上都可達到該數字
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}