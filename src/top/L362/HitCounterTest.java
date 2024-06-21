package top.L362;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HitCounterTest {
    @Test
    public void case1() {
        HitCounter counter = new HitCounter();

        counter.hit(1);
        counter.hit(2);
        counter.hit(3);

        Assertions.assertEquals(3,counter.getHits(4));

        counter.hit(300);

        Assertions.assertEquals(4,counter.getHits(300));
        Assertions.assertEquals(3,counter.getHits(301));
    }

}