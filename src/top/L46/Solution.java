package top.L46;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(new ArrayList<>(), nums);
        return res;
    }

    private void backtrack(List<Integer> tempList, int[] nums) {
        // 符合條件
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for (int num : nums) {
            // 有相同元素不處理
            if (tempList.contains(num)) {
                continue;
            }
            tempList.add(num);
            backtrack(tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }
}