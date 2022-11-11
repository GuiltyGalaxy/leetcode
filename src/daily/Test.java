package daily;

import java.util.LinkedList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		new Test();
	}

	Test() {
		longestCommonPrefix(new String[] { "", "" });
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 1) {
			return strs[0];
		}
		StringBuilder sb = new StringBuilder();
		List<char[]> list = new LinkedList<>();
		int minLength = Integer.MAX_VALUE;
		for (String s : strs) {
			list.add(s.toCharArray());
			minLength = Math.min(minLength, s.length());
		}
		if (minLength == 0) {
			return "";
		}
		char[] str = list.get(0);
		for (int i = 0; i < minLength; i++) {
			for (char[] c : list) {
				if (str[i] != c[i]) {
					return sb.toString();
				}
			}
			sb.append("" + str[i]);
		}
		return sb.toString();
	}
}
