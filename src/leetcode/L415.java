package leetcode;

public class L415 {

	public static void main(String[] args) {
		new L415();
	}

	L415() {
		addStrings("11", "123");
	}

	public String addStrings(String num1, String num2) {
		StringBuilder ans = new StringBuilder();

		char[] a = num1.toCharArray();
		char[] b = num2.toCharArray();
		int idx_a = a.length - 1;
		int idx_b = b.length - 1;
		int carry = 0;
		while (idx_a > -1 || idx_b > -1) {
			int sum = 0;
			if (idx_a > -1) {
				sum += a[idx_a--] - '0';
			}
			if (idx_b > -1) {
				sum += b[idx_b--] - '0';
			}
			sum += carry;
			carry = sum / 10;
			sum = sum % 10;
			ans.append(sum);
		}

		if (carry > 0) {
			ans.append("1");
		}

		return ans.reverse().toString();
	}
}
