package leetcode;

public class L12 {

	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num / 1000; i++) {
			sb.append('M');
		}
		// 1000以下直接列舉即可
		String C[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String X[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String I[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		return sb.append(C[(num % 1000) / 100]).append(X[(num % 100) / 10]).append(I[num % 10]).toString();
	}
}
