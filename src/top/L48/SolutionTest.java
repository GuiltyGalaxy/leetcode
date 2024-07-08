package top.L48;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        int[][] ans = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solution.rotate(ans);
        Assertions.assertArrayEquals(ans, new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        });
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        int[][] ans = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        solution.rotate(ans);
        Assertions.assertArrayEquals(ans, new int[][]{
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
        });
    }
}