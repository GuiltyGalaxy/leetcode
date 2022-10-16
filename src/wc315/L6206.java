package wc315;

public class L6206 {
	public static void main(String[] args) {
		new L6206();
	}

	L6206() {
	}

	public boolean sumOfNumberAndReverse(int num) {

		if (num == 0) {
			return true;
		}
		// 巡遍所有可能
		// 其中i不可能會超過原數一半
		// 因2個數一定有個比num小
		// 找比他小的那個目標即可
		for (int i = 1; i <= num / 2; i++) {
			int tmp = num - i;
			StringBuilder sb = new StringBuilder(String.valueOf(tmp));
			// tmp與反轉數箱家符合則為答案
			if (tmp + Integer.valueOf(sb.reverse().toString()) == num) {
				return true;
			}
		}
		return false;
	}
}
