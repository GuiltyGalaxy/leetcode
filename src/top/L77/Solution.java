package top.L77;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        recursive(1, n, k, new ArrayList<>());
        return result;
    }

    private void recursive(int start, int end, int remaining, List<Integer> list) {

        //找到目標加入至result
        if (remaining == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        //剩下長度不夠remaining則不用計算
        //加上這行 38ms => 5ms
        if (end - start + 1 < remaining) {
            return;
        }

        for (int i = start; i <= end; i++) {
            list.add(i);
            //以現有list繼續去往下找
            recursive(i + 1, end, remaining - 1, list);
            //找過則移除最後
            list.remove(list.size() - 1);
        }
    }
}