package contest.wc333.L2570;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void mergeArrays() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(
                solution.mergeArrays(new int[][]{{1, 2}, {2, 3}, {4, 5}}, new int[][]{{1, 4}, {3, 2}, {4, 1}})
                , new int[][]{{1, 6}, {2, 3}, {3, 2}, {4, 6}});
    }
}