package contest.bc89;

public class L6208 {
	public static void main(String[] args) {
		new L6208();
	}

	L6208() {

	}

	public int countTime(String time) {
		if (time.charAt(0) == '?' && time.charAt(1) == '?' && time.charAt(3) == '?' && time.charAt(4) == '?') {
			return 1440;
		}
		int ans = 1;
		if (time.charAt(0) == '?' && time.charAt(1) == '?') {
			ans = 24;
		} else if (time.charAt(0) == '2' && time.charAt(1) == '?') {
			ans = 4;
		} else if ((time.charAt(0) == '1' || time.charAt(0) == '0') && time.charAt(1) == '?') {
			ans = 10;
		} else if (time.charAt(0) == '?') {
			if (time.charAt(1) >= '4') {
				ans = 2;
			} else {
				ans = 3;
			}
		}
		if (time.charAt(3) == '?') {
			ans *= 6;
		}
		if (time.charAt(4) == '?') {
			ans *= 10;
		}
		return ans;
	}
}
