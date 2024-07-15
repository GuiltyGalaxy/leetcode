package contest.wc406.L3216;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals("43520", solution.getSmallestString("45320"));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals("001", solution.getSmallestString("001"));
    }


    @Test
    void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals("102", solution.getSmallestString("102"));
    }


    @Test
    void case4() {
        Solution solution = new Solution();
        Assertions.assertEquals("130", solution.getSmallestString("130"));
    }
}