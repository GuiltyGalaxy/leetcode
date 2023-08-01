package top.L78;

import java.util.ArrayList;
import java.util.List;

class Solution {


    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<Integer> tempList, int[] nums, int start) {
        res.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}