package contest.wc334.L2570;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(solution.leftRigthDifference(new int[]{10, 4, 8, 3}), new int[]{15, 1, 11, 22});
    }
}