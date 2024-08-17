package top.L80;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 確保順序讓重複的元素排在一起
        Arrays.sort(nums);
        ans = new ArrayList<>();
        backTrack(new ArrayList<>(), 0, nums);
        return ans;
    }

    public void backTrack(List<Integer> list, int index, int[] n) {
        ans.add(list);
        int i = index;
        while (i < n.length) {
            list.add(n[i]);
            backTrack(new ArrayList<>(list), i + 1, n);
            list.remove(list.size() - 1);
            // 重複元素不列入
            do {
                i++;
            } while (i < n.length && n[i] == n[i - 1]);
        }
    }
}