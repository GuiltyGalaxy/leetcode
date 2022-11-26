package top.L973;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(solution.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1), new int[][]{{-2, 2}});
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(solution.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2), new int[][]{{3, 3}, {-2, 4}});
    }
}