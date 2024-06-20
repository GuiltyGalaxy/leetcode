package top.L621;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(8, solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(6, solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 1));
    }


    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(10, solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3));
    }
}