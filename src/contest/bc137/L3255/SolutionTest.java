package contest.bc137.L3255;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(new int[]{3, 4, -1, -1, -1}, solution.resultsArray(new int[]{1, 2, 3, 4, 3, 2, 5}, 3));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(new int[]{1, 4}, solution.resultsArray(new int[]{1, 4}, 1));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(new int[]{-1, 3, -1, 3, -1}, solution.resultsArray(new int[]{3, 2, 3, 2, 3, 2}, 2));
    }

    @Test
    void case4() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(new int[]{-1, 34, -1, -1, -1, -1}, solution.resultsArray(new int[]{4, 30, 31, 32, 33, 34, 5, 6, 4, 4}, 5));
    }
}