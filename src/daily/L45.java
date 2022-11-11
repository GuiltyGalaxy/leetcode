package daily;

public class L45 {
	public static void main(String[] args) {
		new L45();
	}

	L45() {
		jump(new int[] { 2, 3, 1, 1, 4 });
	}

	public int jump(int[] nums) {
		int jumps = 0, curEnd = 0, curFarthest = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			curFarthest = Math.max(curFarthest, i + nums[i]);
			if (i == curEnd) {
				jumps++;
				curEnd = curFarthest;
			}
		}
		return jumps;
	}
}
