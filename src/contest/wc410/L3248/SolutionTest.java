package contest.wc410.L3248;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(3, solution.finalPositionOfSnake(2, List.of("RIGHT", "DOWN")));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(1, solution.finalPositionOfSnake(3, List.of("DOWN", "RIGHT", "UP")));
    }
}