package leetcode;

import java.util.HashMap;
import java.util.Map;

public class L13 {
	@SuppressWarnings("serial")
	Map<String, Integer> MAP = new HashMap<>() {
		{
			put("I", 1);
			put("V", 5);
			put("X", 10);
			put("L", 50);
			put("C", 100);
			put("D", 500);
			put("M", 1000);
		}
	};

	public int romanToInt(String s) {

		int ret = 0;
		char before = 0;

		for (char c : s.toCharArray()) {
			if (before == 'I' && c == 'V') {
				ret -= 2;
			}
			if (before == 'I' && c == 'X') {
				ret -= 2;
			}
			if (before == 'X' && c == 'L') {
				ret -= 20;
			}
			if (before == 'X' && c == 'C') {
				ret -= 20;
			}
			if (before == 'C' && c == 'D') {
				ret -= 200;
			}
			if (before == 'C' && c == 'M') {
				ret -= 200;
			}
			ret += MAP.get(String.valueOf(c)).intValue();
			before = c;
		}

		return ret;
	}
}
