package contest.wc316;

import java.util.Arrays;

public class L6215 {
    L6215() {
        subarrayGCD(new int[]{3, 6, 12, 2, 6, 3}, 3);
    }

    public static void main(String[] args) {
        new L6215();
    }

    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int begin = 0;
        int result = 0;
        //i == n 是為了要計算最後結果
        for (int i = 0; i <= n; i++) {
            //在i < n 的情況下持續更新最大公因數
            if (i < n && nums[i] % k == 0) {
                //整除的情況就當最大公因數為nums[i] /= k
                nums[i] /= k;
            } else {
                //不符合情況時
                //且begin < i有達成連續條件
                //計算subCount
                if (begin < i) {
                    result += subCount(Arrays.copyOfRange(nums, begin, i));
                }
                //begin往後推延i+1
                begin = i + 1;
            }
        }
        return result;
    }

    private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }

    /**
     * 計算[a]中符合最大公因數為1的組合結果
     * ex.[1,2,4]
     * [1,2] [1,4] [1]可以為一組
     * 但[2,4] [2] [4]不可
     * @param a
     * @return
     */
    private int subCount(int[] a) {
        int len = a.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            int g = a[i];
            int j = i;
            while (g > 1 && ++j < len) {
                g = gcd(g, a[j]);
            }
            result += len - j;
        }
        return result;
    }
}
