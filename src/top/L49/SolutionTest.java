package top.L49;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        List<List<String>> ans = new LinkedList<>();
        ans.add(List.of("eat", "tea", "ate"));
        ans.add(List.of("bat"));
        ans.add(List.of("tan", "nat"));
        Assertions.assertIterableEquals(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}), ans);
    }

}