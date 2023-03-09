package top.L127;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(
                solution.ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"))
                , 5);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(
                solution.ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log"))
                , 0);
    }
}