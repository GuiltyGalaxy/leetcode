package contest.wc404.L3200;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(3,solution.maxHeightOfTriangle(2,4));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(2,solution.maxHeightOfTriangle(2,1));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(1,solution.maxHeightOfTriangle(1,1));
    }

    @Test
    void case4() {
        Solution solution = new Solution();
        Assertions.assertEquals(2,solution.maxHeightOfTriangle(10,1));
    }
}