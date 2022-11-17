package daily.L223;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.computeArea(-3, 0, 3, 4, 0, -1, 9, 2), 45);
    }
}