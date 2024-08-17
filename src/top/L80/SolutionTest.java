package top.L80;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertIterableEquals(solution.subsetsWithDup(new int[]{1, 2, 2}), List.of(
                List.of(),
                List.of(1),
                List.of(1, 2),
                List.of(1, 2, 2),
                List.of(2),
                List.of(2, 2)
        ));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertIterableEquals(solution.subsetsWithDup(new int[]{0}), List.of(
                List.of(),
                List.of(0)
        ));
    }
}