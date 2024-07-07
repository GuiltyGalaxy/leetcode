package contest.wc405.L3210;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals("tdar", solution.getEncryptedString("dart", 3));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals("aaa", solution.getEncryptedString("aaa", 1));
    }

}