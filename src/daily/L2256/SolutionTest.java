package daily.L2256;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.minimumAverageDifference(new int[]{2, 5, 3, 9, 5, 3}), 3);
    }

}