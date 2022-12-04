package contest.wc314;

public class L6200 {
	public static void main(String[] args) {
		new L6200();
	}

	L6200() {
		findArray(new int[] { 5, 2, 0, 3, 1 });
	}

	public int[] findArray(int[] pref) {
		int[] ans = new int[pref.length];
		// 預先帶入0的值比較好算
		ans[0] = pref[0];
		for (int i = 1; i < pref.length; i++) {
			// XOR特性，只要把pref[i] ^ pref[i - 1]就可以知道下個
			ans[i] = pref[i] ^ pref[i - 1];
		}
		return ans;
	}
}
