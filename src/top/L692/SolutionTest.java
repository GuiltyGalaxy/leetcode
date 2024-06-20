package top.L692;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertIterableEquals(List.of("i", "love"), solution.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertIterableEquals(List.of("the", "is", "sunny", "day"), solution.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

}