package contest.wc405.L3213;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(7,
                solution.minimumCost("abcdef",
                        new String[]{"abdef", "abc", "d", "def", "ef"},
                        new int[]{100, 1, 1, 10, 5})
        );
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(1,
                solution.minimumCost("r",
                        new String[]{"r", "r", "r", "r"},
                        new int[]{1, 6, 3, 3})
        );
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(5,
                solution.minimumCost("rlmztqsv",
                        new String[]{"r", "rlmztq", "z", "sv"},
                        new int[]{1, 1, 1, 4})
        );
    }
}