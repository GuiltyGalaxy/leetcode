package top.L1730;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(3, solution.getFood(new char[][]{
                {'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', '*', 'O', 'O', 'O', 'X'},
                {'X', 'O', 'O', '#', 'O', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X'}
        }));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(-1, solution.getFood(new char[][]{
                {'X', 'X', 'X', 'X', 'X'},
                {'X', '*', 'X', 'O', 'X'},
                {'X', 'O', 'X', '#', 'X'},
                {'X', 'X', 'X', 'X', 'X'}
        }));
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(6, solution.getFood(new char[][]{
                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', '*', 'O', 'X', 'O', '#', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'O', 'O', '#', 'O', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
        }));
    }

    @Test
    public void case4() {
        Solution solution = new Solution();
        Assertions.assertEquals(2, solution.getFood(new char[][]{
                {'O', '*'},
                {'#', 'O'},
        }));
    }

    @Test
    public void case5() {
        Solution solution = new Solution();
        Assertions.assertEquals(-1, solution.getFood(new char[][]{
                {'X', '*'},
                {'#', 'X'},
        }));
    }
}