package contest.bc135.L3224;


class Solution {
    public int minChanges(int[] nums, int k) {
        // 記錄不同差異的次數
        int[] d = new int[k + 2];
        int n = nums.length;
        // 假設 k = 6
        //     [0,1,2,3,5
        //      4,5,6,3,4]
        //      4 4 4 0 1
        // maxX 6 5 6 3 5 (該值代表在只變動一個數字的情況下，最多差異可到多少)
        // X=0 -> 4 ops
        // X=1 -> 4 ops
        // X=2 -> 5 ops
        // X=3 -> 5 ops
        // X=4 -> 4 ops (有1個maxX小於4 所以2+2)
        // X=5 -> 5 ops (有1個maxX小於4 所以3+2)
        // X=6 -> 8 ops (有3個maxX小於4 所以2+6)

        for (int i = 0; i < n / 2; i++) {
            int min = Math.min(nums[i], nums[n - i - 1]);
            int max = Math.max(nums[i], nums[n - i - 1]);
            d[0] += 1;
            d[max - min] -= 1;
            d[max - min + 1] += 1;
            d[Math.max(max, k - min) + 1] += 1;
        }
        // 最大可能就是每個數字都要動
        int ans = n;
        int s = 0;
        for (int x : d) {
            s += x;
            ans = Math.min(ans, s);
        }
        return ans;
    }
}