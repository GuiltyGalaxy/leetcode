package leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class L2136 {
    L2136() {

    }

    public static void main(String[] args) {
        new L2136();
    }

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < plantTime.length; i++) {
            int[] tmp = new int[2];
            tmp[0] = growTime[i];
            tmp[1] = plantTime[i];
            list.add(tmp);
        }
        //生長最慢的優先種植
        //因在生長期間可以先種其他植物
        list.sort(Comparator.comparing((a) -> -a[0]));

        int ans = 0;
        int cur = 0;
        for (int[] tmp : list) {
            //在依照順序種植的情況下
            //第1朵的開花時間為 0 + plantTime_0 + growTime_0
            //第2朵的開花時間為 (0 + plantTime_0) + plantTime_1 + growTime_1
            //第n+1朵的開花時間為 (0 + plantTime_0 + plantTime_1 + ... + plantTime_(n - 1)) + plantTime_n + growTime_n
            //所以累加起來可以簡化成下列算式
            ans = Math.max(ans, cur + tmp[0] + tmp[1]);
            cur += tmp[1];
        }
        return ans;
    }
}
