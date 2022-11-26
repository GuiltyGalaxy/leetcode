package daily.L907;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.sumSubarrayMins(new int[]{3, 1, 2, 4}), 17);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.sumSubarrayMins(new int[]{11, 81, 94, 43, 3}), 444);
    }
}