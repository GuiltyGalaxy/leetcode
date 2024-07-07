package contest.wc405.L3211;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertIterableEquals(List.of("1", "0"), solution.validStrings(1));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertIterableEquals(List.of("111", "110", "101", "011", "010"), solution.validStrings(3));
    }

}