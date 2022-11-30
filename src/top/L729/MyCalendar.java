package top.L729;

import java.util.Map;
import java.util.TreeMap;

class MyCalendar {

    TreeMap<Integer, Integer> treemap = new TreeMap<>();

    public MyCalendar() {
    }

    public boolean book(int start, int end) {

        //先尋找tree中接近end的值
        Map.Entry<Integer, Integer> entry = treemap.lowerEntry(end);

        //其Value>start代表start於tree有重疊
        if (entry != null && entry.getValue() > start) {
            return false;
        }

        treemap.put(start, end);

        return true;


    }
}