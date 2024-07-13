package top.L721;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        List<List<String>> in = new LinkedList<>();
        in.add(List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        in.add(List.of("John", "johnsmith@mail.com", "john00@mail.com"));
        in.add(List.of("Mary", "mary@mail.com"));
        in.add(List.of("John", "johnnybravo@mail.com"));

        List<List<String>> ans = new LinkedList<>();
        ans.add(List.of("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"));
        ans.add(List.of("Mary", "mary@mail.com"));
        ans.add(List.of("John", "johnnybravo@mail.com"));
        Assertions.assertIterableEquals(ans, solution.accountsMerge(in));
    }

}