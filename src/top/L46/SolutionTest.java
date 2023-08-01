package top.L46;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertIterableEquals(solution.permute(new int[]{1, 2, 3}), List.of(
                List.of(1, 2, 3),
                List.of(1, 3, 2),
                List.of(2, 1, 3),
                List.of(2, 3, 1),
                List.of(3, 1, 2),
                List.of(3, 2, 1)
        ));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertIterableEquals(solution.permute(new int[]{0, 1}), List.of(
                List.of(0, 1),
                List.of(1, 0)
        ));
    }
}