package daily;

public class L387 {
	public static void main(String[] args) {
		new L387();
	}

	L387() {
		firstUniqChar("loveleetcode");
	}

	public int firstUniqChar(String s) {
		int[][] map = new int[26][2];

		for (int i = 0; i < map.length; i++) {
			map[i][0] = -1;
			map[i][1] = 0;
		}
		int i = 0;
		for (char c : s.toCharArray()) {
			if (map[c - 'a'][0] == -1) {
				map[c - 'a'][0] = i;
			}
			map[c - 'a'][1]++;
			i++;
		}
		int min = Integer.MAX_VALUE;
		for (int[] c : map) {
			if (c[1] == 1) {
				min = Math.min(c[0], min);
			}
		}
		if (min == Integer.MAX_VALUE) {
			min = -1;
		}
		return min;
	}
}
