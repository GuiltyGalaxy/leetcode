package top.L1268;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        List<List<String>> ans = new ArrayList<>();
        ans.add(List.of("mobile","moneypot","monitor"));
        ans.add(List.of("mobile","moneypot","monitor"));
        ans.add(List.of("mouse","mousepad"));
        ans.add(List.of("mouse","mousepad"));
        ans.add(List.of("mouse","mousepad"));
        Assertions.assertIterableEquals(solution.suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}
                , "mouse"),ans);
    }

}