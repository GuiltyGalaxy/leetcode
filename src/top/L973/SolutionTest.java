package top.L973;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(new int[][]{{-2, 2}}, solution.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1));
        Assertions.assertArrayEquals(new int[][]{{-2, 2}}, solution.kClosest2(new int[][]{{1, 3}, {-2, 2}}, 1));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(new int[][]{{-2, 4}, {3, 3}}, solution.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2));
        Assertions.assertArrayEquals(new int[][]{{3, 3}, {-2, 4}}, solution.kClosest2(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2));
    }
}