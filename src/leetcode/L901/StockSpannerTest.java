package leetcode.L901;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class StockSpannerTest {
    @Test
    public void case1() {
        StockSpanner stockSpanner = new StockSpanner();
        Assertions.assertEquals(stockSpanner.next(100),1);
        Assertions.assertEquals(stockSpanner.next(80),1);
        Assertions.assertEquals(stockSpanner.next(60),1);
        Assertions.assertEquals(stockSpanner.next(70),2);
        Assertions.assertEquals(stockSpanner.next(60),1);
        Assertions.assertEquals(stockSpanner.next(75),4);
        Assertions.assertEquals(stockSpanner.next(85),6);
    }

}