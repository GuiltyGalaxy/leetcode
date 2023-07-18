package top.L217;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> integers = new HashSet<>(nums.length);
        for (int num : nums) {
            if (!integers.add(num)) {
                return true;
            }
        }
        return false;
    }
}
