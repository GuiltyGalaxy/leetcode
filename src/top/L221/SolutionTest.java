package top.L221;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(4, solution.maximalSquare(new char[][]{
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}
                }
        ));
    }


    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(1, solution.maximalSquare(new char[][]{
                        {'0', '1'},
                        {'1', '0'},
                }
        ));
    }


    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(0, solution.maximalSquare(new char[][]{{'0'}}));
    }
}