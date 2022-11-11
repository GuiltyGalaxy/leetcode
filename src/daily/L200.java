package daily;

public class L200 {
	public static void main(String[] args) {
		new L200();
	}

	L200() {
		canConstruct("a", "b");
	}

	public boolean canConstruct(String ransomNote, String magazine) {
		int[] map = new int[26];
		for (char c : magazine.toCharArray()) {
			map[c - 'a']++;
		}
		for (char c : ransomNote.toCharArray()) {
			map[c - 'a']--;
			if (map[c - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}
}
