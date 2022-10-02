package leetcode;

import java.util.HashSet;
import java.util.Set;

public class L804 {
	public static void main(String[] args) {
		new L804();
	}

	String[] CODE_MAP = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
			".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
			"--.." };

	public int uniqueMorseRepresentations(String[] words) {
		Set<String> set = new HashSet<>();
		for (String s : words) {
			StringBuilder sb = new StringBuilder();
			for (char c : s.toCharArray()) {
				sb.append(CODE_MAP[c - 'a']);
			}
			set.add(sb.toString());
		}

		return set.size();
	}
}
