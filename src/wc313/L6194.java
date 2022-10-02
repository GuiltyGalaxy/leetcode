package wc313;

public class L6194 {
	public static void main(String[] args) {
		new L6194();
	}

	L6194() {
		minimizeXor(1, 12);
	}

	public int minimizeXor(int num1, int num2) {
		int bit = Integer.bitCount(num2);
		String s = Integer.toBinaryString(num1);
		for (int i = 0; i < 32 - s.length(); i++) {
			s = "0" + s;
		}
		StringBuilder sb = new StringBuilder("");
		for (char c : s.toCharArray()) {
			if (c == '1' && bit > 0) {
				bit--;
				sb.append('1');
			} else {
				sb.append('0');
			}
		}
		sb.reverse();
		while (bit > 0) {
			int idx = sb.indexOf("0");
			if (idx >= 0) {
				sb.replace(idx, idx + 1, "1");
			} else {
				sb.append('1');
			}
			bit--;
		}
		sb.reverse();
		return Integer.parseInt(sb.toString(), 2);
	}
}
