package bc89;

public class L6210 {
	public static void main(String[] args) {
		new L6210();
	}

	L6210() {
		minimizeArrayValue(new int[] { 4, 7, 2, 2, 9, 19, 16, 0, 3, 15 });
	}

	public int minimizeArrayValue(int[] nums) {
		long minmax = 0;
		long sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			// 計算整數的平均數算法
			// (sum + i) / (i + 1)
			// ex. 7 = 3+2+2
			// sum = 7,i = 2
			// (7+2)/(2+1) = 3
			minmax = Math.max((sum + i) / (i + 1), minmax);
		}
		return (int) minmax;
	}
}
