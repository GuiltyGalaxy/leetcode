package top.L1197;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(1, solution.minKnightMoves(2, 1));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(4, solution.minKnightMoves(5, 5));
    }
}