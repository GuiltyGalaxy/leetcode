package contest.wc333.L2571;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void minOperations() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.minOperations(1),1);
        Assertions.assertEquals(solution.minOperations(39),3);
        Assertions.assertEquals(solution.minOperations(54),3);
        Assertions.assertEquals(solution.minOperations(38),3);
        Assertions.assertEquals(solution.minOperations(33),2);
        Assertions.assertEquals(solution.minOperations(26),3);
    }
}