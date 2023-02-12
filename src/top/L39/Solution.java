package top.L39;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> current = new ArrayList<>();
        helper(candidates, target, 0, current);
        return ans;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> current) {
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) continue;
            current.add(candidates[i]);
            helper(candidates, target - candidates[i], i, current);
            current.remove(current.size() - 1);
        }

    }
}