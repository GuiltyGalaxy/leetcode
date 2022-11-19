package top.L17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        List<String> a = Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf");
        Assertions.assertIterableEquals(solution.letterCombinations("23"), a);
    }

}