package top.L39;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //存放當前集合的總數
        List<Integer> current = new ArrayList<>();
        combinationSumHelper(0, candidates, target, current);
        return result;
    }

    private void combinationSumHelper(int index, int[] candidates, int target, List<Integer> current) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        //以當前idx尋找所有可能，包含自己
        for (int i = index; i < candidates.length; i++) {
            //選擇大於目標就不考慮了
            if (candidates[i] > target) continue;

            current.add(candidates[i]);
            combinationSumHelper(i, candidates, target - candidates[i], current);
            current.remove(current.size() - 1);
        }
    }
}