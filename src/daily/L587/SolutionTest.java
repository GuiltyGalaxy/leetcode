package daily.L587;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(
                solution.outerTrees(new int[][]{{1, 1}, {2, 2}, {2, 0}, {2, 4}, {3, 3}, {4, 2}}),
                new int[][]{{1, 1}, {2, 4}, {3, 3}, {4, 2}, {2, 0}});
    }

}