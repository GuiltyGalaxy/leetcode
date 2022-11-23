package top.L1300;

class Solution {
    public int findBestValue(int[] arr, int target) {

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int a : arr) {
            sum += a;
            max = Math.max(max, a);
        }

        //相等就不用異動了
        if (sum == target) {
            return max;
        }

        int min = 0;
        int ans = 1;
        //紀錄目前ans與sum的diff
        int diff = Integer.MAX_VALUE;

        //於min至max使用BS去找符合target條件的數
        while (min <= max) {
            int mid = (max + min) / 2;
            sum = getMutatedSum(arr, mid);
            if (sum > target) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
            //答案不一定會剛好為target
            //所以兩種條件都要列入計算
            boolean isLessDiff = Math.abs(sum - target) < diff;
            boolean isEqualDiff = Math.abs(sum - target) == diff && mid < ans;
            if (isLessDiff || isEqualDiff) {
                ans = mid;
                diff = Math.abs(sum - target);
            }
        }
        return ans;
    }

    /**
     * 以mid為基準去算sum結果
     */
    private int getMutatedSum(int[] arr, int mid) {
        int sum = 0;
        for (int a : arr) {
            sum += Math.min(a, mid);
        }
        return sum;
    }
}