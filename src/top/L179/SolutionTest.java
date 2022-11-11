package top.L179;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.largestNumber(new int[]{3, 30, 34, 5, 9}), "9534330");
    }


}