package top.L269;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals("wertf", solution.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals("zx", solution.alienOrder(new String[]{"z", "x"}));
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals("", solution.alienOrder(new String[]{""}));
    }

}