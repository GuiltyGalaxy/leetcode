package daily;

import java.util.HashMap;
import java.util.Map;

public class L523 {

    L523() {
        checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6);
    }

    public static void main(String[] args) {
        new L523();
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        //如有連續sum為k的倍數
        //ex.[5,2,1,5],k=3,則[2,1]符合
        //利用累進餘數會發現
        // 5 % 3 => 2
        // (2 + 2) % 3 => 1
        // (1 + 1) % 3 => 2
        //當有連續合的餘數重複出現
        //代表中間之合是k的倍數
        Map<Integer, Integer> map = new HashMap<>();
        //只要是在不是nums[0]的位子發生累進餘數是整除的情況
        //代表中間和直接達成條件
        //因餘數0就直接是代表整除了
        //所以要先put一個(0,-1)
        map.put(0, -1);
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            //計算累進餘數
            runningSum = (runningSum + nums[i]) % k;

            Integer prev = map.get(runningSum);
            if (prev == null) {
                map.put(runningSum, i);
                continue;
            }
            //如有出現相同之和且距離超過1代表連續
            if (i - prev > 1) {
                return true;
            }
        }
        return false;
    }
}
