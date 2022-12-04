package contest.wc318.L2460;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(solution.applyOperations(new int[]{1, 2, 2, 1, 1, 0}), new int[]{1, 4, 2, 0, 0, 0});
    }

}