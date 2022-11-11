package daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L835 {
    L835() {

    }

    public static void main(String[] args) {
        new L835();
    }

    public int largestOverlap(int[][] img1, int[][] img2) {

        int N = img1.length;
        List<Integer> L1 = new ArrayList<>();
        List<Integer> L2 = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();

        //將2D座標轉換成1D座標
        //ex,[12,9] +> 12*100 + 9 = 1209
        //且該座標如果為1就將該座標點add to list
        for (int i = 0; i < N * N; i++)
            if (img1[i / N][i % N] == 1)
                L1.add(i / N * 100 + i % N);

        for (int i = 0; i < N * N; i++)
            if (img2[i / N][i % N] == 1)
                L2.add(i / N * 100 + i % N);

        //計算所有可能
        //i-j代表說滑動偏差
        //ex. 在滑動偏差為0的情況(就是兩張圖直接疊合)
        //    此時的L1 1209對應L2 1209如果都為1就代表該點重合
        //ex. 在滑動偏差為1的情況(圖一向上移動)
        //    此時的L1 1210對應L2 1209如果都為1就代表該點重合
        //以此類推
        for (int i : L1)
            for (int j : L2)
                count.put(i - j, count.getOrDefault(i - j, 0) + 1);

        int res = 0;
        for (int i : count.values())
            res = Math.max(res, i);

        return res;
    }

}
