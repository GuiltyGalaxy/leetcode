package top.L146;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LRUCacheTest {
    @Test
    public void case1() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        Assertions.assertEquals(lRUCache.get(1), 1);
        lRUCache.put(3, 3);
        Assertions.assertEquals(lRUCache.get(2), -1);
        lRUCache.put(4, 4);
        Assertions.assertEquals(lRUCache.get(1), -1);
        Assertions.assertEquals(lRUCache.get(3), 3);
        Assertions.assertEquals(lRUCache.get(4), 4);
    }


}