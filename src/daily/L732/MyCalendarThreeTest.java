package daily.L732;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyCalendarThreeTest {
    @Test
    public void case1() {
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        Assertions.assertEquals(myCalendarThree.book(10, 20), 1);
        Assertions.assertEquals(myCalendarThree.book(50, 60), 1);
        Assertions.assertEquals(myCalendarThree.book(10, 40), 2);
        Assertions.assertEquals(myCalendarThree.book(5, 15), 3);
        Assertions.assertEquals(myCalendarThree.book(5, 10), 3);
        Assertions.assertEquals(myCalendarThree.book(25, 55), 3);
    }
}