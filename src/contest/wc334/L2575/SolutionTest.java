package contest.wc334.L2575;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(solution.divisibilityArray("998244353", 3), new int[]{1, 1, 0, 0, 0, 1, 1, 0, 0});
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(solution.divisibilityArray("1010", 10), new int[]{0, 1, 0, 1});
    }
}