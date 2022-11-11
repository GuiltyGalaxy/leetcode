package daily.L212;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertLinesMatch(solution.findWords(
                        new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}},
                        new String[]{"oath", "pea", "eat", "rain"}),
                Arrays.asList("eat", "oath"));
    }

}