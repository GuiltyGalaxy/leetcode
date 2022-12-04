package contest.wc312;

public class L6189 {
	public static void main(String[] args) {
		new L6189();
	}

	L6189() {

	}

	public int longestSubarray(int[] nums) {
		int max = 0;
		for (int n : nums) {
			max = Math.max(max, n);
		}
		int size = 0;
		int tmp = 0;
		for (int n : nums) {
			if (n != max) {
				size = Math.max(size, tmp);
				tmp = 0;
				continue;
			}
			tmp++;
		}
		size = Math.max(size, tmp);
		return size;
	}
}
