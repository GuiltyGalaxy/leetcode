package top.L190;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        int ans = solution.reverseBits(Integer.parseUnsignedInt("11111111111111111111111111111101", 2));
        int ans2 = solution.reverseBits2(Integer.parseUnsignedInt("11111111111111111111111111111101", 2));
        Assertions.assertEquals(Integer.toUnsignedLong(ans), 3221225471L);
        Assertions.assertEquals(Integer.toUnsignedLong(ans2), 3221225471L);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        int ans = solution.reverseBits(Integer.parseUnsignedInt("00000010100101000001111010011100", 2));
        int ans2 = solution.reverseBits2(Integer.parseUnsignedInt("00000010100101000001111010011100", 2));
        Assertions.assertEquals(Integer.toUnsignedLong(ans), 964176192L);
        Assertions.assertEquals(Integer.toUnsignedLong(ans2), 964176192L);
    }

}