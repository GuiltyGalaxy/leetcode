package top.L91;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(2, solution.numDecodings("12"));
        Assertions.assertEquals(2, solution.numDecodings2("12"));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(3, solution.numDecodings("226"));
        Assertions.assertEquals(3, solution.numDecodings2("226"));
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(0, solution.numDecodings("06"));
        Assertions.assertEquals(0, solution.numDecodings2("06"));
    }


    @Test
    public void case4() {
        Solution solution = new Solution();
        Assertions.assertEquals(1, solution.numDecodings("10"));
        Assertions.assertEquals(1, solution.numDecodings2("10"));
    }
}