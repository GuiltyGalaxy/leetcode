package top.L729;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyCalendarTest {
    @Test
    public void case1() {
        MyCalendar myCalendar = new MyCalendar();
        Assertions.assertTrue(myCalendar.book(10, 20));
        Assertions.assertFalse(myCalendar.book(15, 25));
        Assertions.assertTrue(myCalendar.book(20, 30));
    }
}