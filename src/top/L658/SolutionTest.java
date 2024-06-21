package top.L658;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertIterableEquals(List.of(1, 2, 3, 4), solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
        Assertions.assertIterableEquals(List.of(1, 2, 3, 4), solution.findClosestElements2(new int[]{1, 2, 3, 4, 5}, 4, 3));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertIterableEquals(List.of(1, 2, 3, 4), solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));
        Assertions.assertIterableEquals(List.of(1, 2, 3, 4), solution.findClosestElements2(new int[]{1, 2, 3, 4, 5}, 4, -1));
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertIterableEquals(List.of(2, 3), solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 2, 3));
        Assertions.assertIterableEquals(List.of(2, 3), solution.findClosestElements2(new int[]{1, 2, 3, 4, 5}, 2, 3));
    }
}