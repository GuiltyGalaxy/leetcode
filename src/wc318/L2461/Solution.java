package wc318.L2461;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public long maximumSubarraySum(int[] arr, int k) {

        Set<Integer> set = new HashSet<>();

        //window head && tail
        int head = 0;
        int tail = 0;

        long sum = 0;
        long maxSum = 0;

        while (tail < arr.length) {
            if (!set.contains(arr[tail])) {
                set.add(arr[tail]);
                sum += arr[tail];
                //window符合長度將sum紀錄於maxSum
                if (tail - head + 1 == k) {
                    maxSum = Math.max(maxSum, sum);
                    sum -= arr[head];
                    set.remove(arr[head]);
                    head++;
                }
            } else {
                //重複數字出現重置head
                //window重新計算
                head = tail;
                sum = arr[head];
                set = new HashSet<>();
                set.add(arr[tail]);
            }
            tail++;
        }

        return maxSum;
    }
}
