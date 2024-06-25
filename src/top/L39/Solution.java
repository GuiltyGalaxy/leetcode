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
        // 當target為0代表current中為一組解答
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // candidates[i]就比target大的話不用繼續處理
            if (candidates[i] > target) continue;
            // 加入該值繼續算
            current.add(candidates[i]);
            helper(candidates, target - candidates[i], i, current);
            // 移除該值(一定會在最後所以移除最後就好)
            current.remove(current.size() - 1);
        }

    }
}