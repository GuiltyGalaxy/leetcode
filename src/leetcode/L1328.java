package leetcode;

public class L1328 {

	public static void main(String[] args) {
		new L1328();
	}

	L1328() {
	}

	public String breakPalindrome(String palindrome) {

		if (palindrome.length() == 1) {
			return "";
		}

		char[] c = palindrome.toCharArray();
		// 要達成lexicographically smallest且只換一個字
		// 那就直接找最前面的不是'a'改成'a'
		// 因為palindrome的關係只要找到中間
		for (int i = 0; i < c.length / 2; i++) {
			if (c[i] != 'a') {
				c[i] = 'a';
				return new String(c);
			}
		}

		// 如果全找了都是'a'則替換最後一個字母為'b'
		c[c.length - 1] = 'b';

		return new String(c);
	}
}
