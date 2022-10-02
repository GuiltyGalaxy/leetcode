package leetcode;

public class L5 {

	private final int LEFT = -1;
	private final int MID = 0;
	private final int RIGHT = 1;
	private int begin, maxLen;

	public static void main(String[] args) {
		new L5();
	}

	L5() {
		longestPalindrome("babad");
	}

	public String longestPalindrome(String s) {
		char[] str = s.toCharArray();
		int n = str.length;
		// n / 2 => n >> 1
		// �q�����}�l��
		expandCenter(str, n >> 1, MID);
		return new String(str, begin, maxLen);
	}

	private void expandCenter(char[] str, int idx, int direction) {
		int len = str.length;
		int i = idx - 1;
		int j = idx + 1;

		// �J�����_�l�ۦP���r
		// ex. "naaaaaaan"
		//      ^   ^   ^
		//      |   |   |
		//      i  idx  j
		while (i >= 0 && str[i] == str[idx])
			i--;
		while (j < len && str[j] == str[idx])
			j++;

		// �p��̤j�^�����
		int left = i;
		int right = j;
		while (left >= 0 && right < len && str[left] == str[right]) {
			left--;
			right++;
		}

		// �p�G���e�̤j�^��j�h�O��
		if (right - left - 1 > maxLen) {
			begin = left + 1;
			maxLen = right - left - 1;
		}

		// �ѤU�����צp�G��ثemaxLen�j�A�~�򩹥��k��
		if (((i + 1) << 1) > maxLen && direction <= MID)
			expandCenter(str, i, LEFT);

		if (((len - j) << 1) > maxLen && direction >= MID)
			expandCenter(str, j, RIGHT);
	}

}
