package top.L39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] arr, int sum) {
        Arrays.sort(arr);
        helper(arr, sum, 0, new ArrayList<>());
        return ans;
    }

    private void helper(int[] candidates, int target, int idx, List<Integer> cur) {

        if (idx == candidates.length) {
            return;
        }

        //符合目標值加入至ans
        if (candidates[idx] == target) {
            ArrayList<Integer> tmp = new ArrayList<>(cur);
            tmp.add(candidates[idx]);
            ans.add(tmp);
            return;
        }

        if (candidates[idx] > target) {
            return;
        }
        //找下個idx可能性
        helper(candidates, target, idx + 1, cur);

        ArrayList<Integer> tmp = new ArrayList<>(cur);
        tmp.add(candidates[idx]);
        //同個idx尋找重複使用情況
        helper(candidates, target - candidates[idx], idx, tmp);
    }
}