package contest.wc409.L3243;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(new int[]{3, 2, 1}, solution.shortestDistanceAfterQueries(5,
                new int[][]{{2, 4}, {0, 2}, {0, 4}}
        ));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(new int[]{1, 1}, solution.shortestDistanceAfterQueries(4,
                new int[][]{{0, 3}, {0, 2}}
        ));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(new int[]{3, 3}, solution.shortestDistanceAfterQueries(5,
                new int[][]{{1, 3}, {2, 4}}
        ));
    }
}