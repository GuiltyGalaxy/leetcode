package contest.bc135.L3223;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(5, solution.minimumLength("abaacbcbb"));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(2, solution.minimumLength("aa"));
    }

}