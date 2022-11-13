package daily.L981;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TimeMapTest {

    @Test
    public void case1() {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        Assertions.assertEquals(timeMap.get("foo", 1), "bar");
        Assertions.assertEquals(timeMap.get("foo", 3), "bar");
        timeMap.set("foo", "bar2", 4);
        Assertions.assertEquals(timeMap.get("foo", 4), "bar2");
        Assertions.assertEquals(timeMap.get("foo", 5), "bar2");
    }
}