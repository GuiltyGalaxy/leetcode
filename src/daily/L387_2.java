package daily;

public class L387_2 {
	public int firstUniqChar(String s) {
		int result = s.length();

		for (char c = 'a'; c <= 'z'; c++) {
			int firstIndex = s.indexOf(c);
			if (firstIndex != -1 && firstIndex == s.lastIndexOf(c)) {
				result = Math.min(result, firstIndex);
			}
		}

		return result == s.length() ? -1 : result;
	}
}
