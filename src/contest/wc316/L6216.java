package contest.wc316;

public class L6216 {
    L6216() {
        minCost(new int[]{735103, 366367, 132236, 133334, 808160, 113001, 49051, 735598, 686615, 665317, 999793, 426087, 587000, 649989, 509946, 743518}
                , new int[]{724182, 447415, 723725, 902336, 600863, 287644, 13836, 665183, 448859, 917248, 397790, 898215, 790754, 320604, 468575, 825614});
    }

    public static void main(String[] args) {
        new L6216();
    }

    public long minCost(int[] nums, int[] cost) {
        //假設x會使總cost為最小
        //故這個數會是一個逼近值
        //使用Binary Search去計算
        //就不用窮舉所有可能了
        long left = 1L;
        long right = 1000000L;
        //範圍一定不會超過nums中的min與max
        for (int num : nums) {
            left = Math.min(num, left);
            right = Math.max(num, right);
        }
        //先假設x為1
        long ans = findCost(nums, cost, 1);
        while (left < right) {
            long mid = (left + right) / 2;
            long y1 = findCost(nums, cost, mid);
            long y2 = findCost(nums, cost, mid + 1);
            //ans先更新成當前最小的
            ans = Math.min(y1, y2);
            if (y1 < y2) {
                //向left逼近
                right = mid;
            } else {
                //向right逼近
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 計算以x為基底的nums總cost數
     *
     * @param nums
     * @param cost
     * @param x
     * @return
     */
    private long findCost(int[] nums, int[] cost, long x) {
        long res = 0L;
        for (int i = 0; i < nums.length; i++) {
            res += Math.abs(nums[i] - x) * cost[i];
        }
        return res;
    }
}
