package wc314;

import java.util.Stack;

public class L6202 {
	public static void main(String[] args) {
		new L6202();
	}

	L6202() {
		robotWithString("vzhofnpo");
	}

	public String robotWithString(String s) {
		Stack<String> t = new Stack<>();
		StringBuilder p = new StringBuilder();

		int[] map = new int[26];
		// 整理s字母統計到map中
		for (char c : s.toCharArray()) {
			map[c - 'a']++;
		}

		int idx = findLast(map);
		for (char c : s.toCharArray()) {
			// 找過的情況移除map
			map[c - 'a']--;

			if (idx == c - 'a') {
				p.append(c);
				// 重新尋找idx
				idx = findLast(map);
				// 這邊是防止原先被放到t的值其實小於目前idx
				// 這時反而要把t的先拿出來
				while (!t.isEmpty()) {
					if (idx >= t.peek().charAt(0) - 'a') {
						p.append(t.pop());
					} else {
						break;
					}
				}
			} else {
				// 不是目標先放到t
				t.add(String.valueOf(c));
			}
		}
		
		while (!t.isEmpty()) {
			p.append(t.pop());
		}
		return p.toString();
	}

	// 尋找目前map中可以找到的最大目標
	private int findLast(int[] map) {
		// 最小字典一定是取當前有值的最小i
		for (int i = 0; i < map.length; i++) {
			if (map[i] > 0) {
				return i;
			}
		}
		return -1;
	}
}
