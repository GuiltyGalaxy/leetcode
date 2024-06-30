package contest.wc404.L3202;


class Solution {
    public int maximumLength(int[] nums, int k) {
        // 維護一個2D Array
        // 其中[i][j]
        // i為mod的數
        // j為該mod中結尾為j的次數
        // 為什麼可以這樣算，下面舉例子
        // 如果k為3
        // 那符合條件的子數列有
        // 0 0 0 | 1 1 1 | 2 2 2
        // 0 1 0 | 1 2 1 | 2 0 2
        // 1 0 1 | 2 1 2 | 0 2 0
        // 可能性的陣列大小為k * k
        int[][] dp = new int[k][k];
        int max = 0;
        for (int num : nums) {
            // 把每個結尾都算一次
            for (int j = 0; j < k; j++) {
                // mod = num % k 的 j 結尾要去找 mod = j 的 num % k結尾做匹配
                max = Math.max(max, dp[num % k][j] = dp[j][num % k] + 1);
            }
        }
        return max;
    }
}