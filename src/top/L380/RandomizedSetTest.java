package top.L380;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomizedSetTest {
    @Test
    public void case1() {
        RandomizedSet randomizedSet = new RandomizedSet();
        Assertions.assertTrue(randomizedSet.insert(1));
        Assertions.assertFalse(randomizedSet.remove(2));
        Assertions.assertTrue(randomizedSet.insert(2));
        Assertions.assertTrue(randomizedSet.getRandom()>0);
        Assertions.assertTrue(randomizedSet.remove(1));
        Assertions.assertFalse(randomizedSet.insert(2));
        Assertions.assertEquals(randomizedSet.getRandom(),2);
    }
}