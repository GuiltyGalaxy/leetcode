package top.L310;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertIterableEquals(solution.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}), List.of(1));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertIterableEquals(solution.findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}), List.of(3, 4));
    }
}