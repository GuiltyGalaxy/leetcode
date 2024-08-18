package contest.wc411.L3259;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();

        Assertions.assertEquals(5, solution.maxEnergyBoost(new int[]{1, 3, 1}, new int[]{3, 1, 1}));
    }

    @Test
    void case2() {
        Solution solution = new Solution();

        Assertions.assertEquals(7, solution.maxEnergyBoost(new int[]{4, 1, 1}, new int[]{1, 1, 3}));
    }


    @Test
    void case3() {
        Solution solution = new Solution();

        Assertions.assertEquals(13, solution.maxEnergyBoost(new int[]{3, 3, 3}, new int[]{3, 4, 6}));
    }

    @Test
    void case4() {
        Solution solution = new Solution();

        Assertions.assertEquals(11, solution.maxEnergyBoost(new int[]{3, 3, 4}, new int[]{4, 3, 4}));
    }

    @Test
    void case5() {
        Solution solution = new Solution();

        Assertions.assertEquals(12, solution.maxEnergyBoost(new int[]{3, 5, 3}, new int[]{3, 4, 5}));
    }


    @Test
    void case6() {
        Solution solution = new Solution();

        Assertions.assertEquals(35, solution.maxEnergyBoost(
                new int[]{5, 5, 6, 3, 4, 3, 3, 4},
                new int[]{5, 3, 3, 4, 4, 6, 6, 3})
        );
    }
}