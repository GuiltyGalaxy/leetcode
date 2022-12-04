package contest.bc90;

import java.util.HashMap;
import java.util.Map;

public class L6210 {
    L6210() {
        destroyTargets(new int[]{304415643, 213512562, 667776528, 854523075, 291102158}, 4);
    }

    public static void main(String[] args) {
        new L6210();
    }

    public int destroyTargets(int[] nums, int space) {
        //記錄各組餘數的出現次數
        Map<Integer, Integer> map = new HashMap<>();
        //紀錄原來的數字，並且只記錄最小的
        Map<Integer, Integer> map1 = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            int x = num % space;
            int count = map.getOrDefault(x, 0);
            count++;
            map.put(x, count);
            max = Math.max(max, count);

            if (!map1.containsKey(x) || map1.get(x) > num) {
                map1.put(x, num);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            //該餘數出現次數最多代表該組可一次被提取最多
            if (map.get(key) == max) {
                //只取符合條件中最小的數
                res = Math.min(res, map1.get(key));
            }
        }
        return res;
    }
}
