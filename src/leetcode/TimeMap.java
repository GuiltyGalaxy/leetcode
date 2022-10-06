package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {

	public static void main(String[] args) {
		TimeMap timeMap = new TimeMap();
		timeMap.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1.
		timeMap.get("foo", 1); // return "bar"
		timeMap.get("foo", 3); // return "bar", since there is no value corresponding to foo at timestamp 3 and
								// timestamp 2, then the only value is at timestamp 1 is "bar".
		timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
		timeMap.get("foo", 4); // return "bar2"
		timeMap.get("foo", 5); // return "bar2"
	}

	static class TimedValue {
		int timestamp;
		String value;
		TimedValue(String value, int timestamp) {
			this.value = value;
			this.timestamp = timestamp;
		}
	}

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
		int idx = Collections.binarySearch(tmp, tv, (a, b) -> a.timestamp - b.timestamp);
		// idx為負數代表沒找到符合的值
		// binarySearch會返回最接近的插入點idx
		// 所以轉正後-2就為最接近點
		if (idx < 0) {
			idx = -idx - 2;
		}
		return tmp.get(idx).value;
	}
}
