package top.L981;

import java.util.*;

public class TimeMap {

    Map<String, List<TimedValue>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<TimedValue> tmp = map.getOrDefault(key, new ArrayList<>());
        tmp.add(new TimedValue(value, timestamp));
        map.put(key, tmp);
    }

    public String get(String key, int timestamp) {
        List<TimedValue> tmp = map.get(key);
        if (tmp == null) {
            return "";
        }

        int start = 0;
        int end = tmp.size() - 1;
        // 取最前面的timestamp大於timestamp則代表沒有符合的
        if (tmp.get(start).timestamp > timestamp) {
            return "";
        }
        // 取最後面的timestamp小於timestamp則代表end為最接近的值
        if (tmp.get(end).timestamp < timestamp) {
            return tmp.get(end).value;
        }

        // 使用binary search找最靠近timestamp的value
        String result = "";
        while (start <= end) {
            int mid = (start + end) / 2;
            TimedValue t = tmp.get(mid);
            if (t.timestamp <= timestamp) {
                result = t.value;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    static class TimedValue {
        int timestamp;
        String value;

        TimedValue(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
