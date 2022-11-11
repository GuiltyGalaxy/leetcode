package daily;

public class L334 {
	public static void main(String[] args) {
		new L334();
	}

	L334() {

	}

	public boolean increasingTriplet(int[] nums) {
		// 假設a1,a2兩數
		// a1與a2各別會記錄遇到的最小兩數
		int a1 = Integer.MAX_VALUE;
		int a2 = Integer.MAX_VALUE;
		for (int n : nums) {
			if (n <= a1) {
				a1 = n;
			} else if (n <= a2) {
				a2 = n;
			} else {
				// 如果n大於a1,a2則達成條件
				return true;
			}
		}
		return false;
	}
}
