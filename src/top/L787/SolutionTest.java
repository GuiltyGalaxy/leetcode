package top.L787;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.findCheapestPrice(4
                , new int[][]{
                        {0, 1, 100},
                        {1, 2, 100},
                        {2, 0, 100},
                        {1, 3, 600},
                        {2, 3, 200}
                }, 0, 3, 1), 700);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.findCheapestPrice(3
                , new int[][]{
                        {0, 1, 100},
                        {1, 2, 100},
                        {0, 2, 500}
                }, 0, 2, 1), 200);
    }
}