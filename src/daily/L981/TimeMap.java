package daily.L981;

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

        // 建立搜尋目標
        TimedValue tv = new TimedValue("", timestamp);
        int idx = Collections.binarySearch(tmp, tv, Comparator.comparingInt(a -> a.timestamp));
        // idx為負數代表沒找到符合的值
        // binarySearch會返回最接近的插入點idx
        // 所以轉正後-2就為最接近點
        if (idx < 0) {
            idx = -idx - 2;
        }
        return tmp.get(idx).value;
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
