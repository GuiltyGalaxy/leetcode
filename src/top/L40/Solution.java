package top.L40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(), candidates, target, 0);
        return ans;
    }

    private void backtrack(List<Integer> list, int[] c, int target, int index) {

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < c.length; i++) {
            if (i > index && c[i] == c[i - 1]) {
                continue;
            }
            list.add(c[i]);
            backtrack(list, c, target - c[i], i + 1);
            list.remove(list.size() - 1);
        }

    }
}