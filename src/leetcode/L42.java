package leetcode;

public class L42 {

	public static void main(String[] args) {
		new L42();
	}

	L42() {
		trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
	}

	public int trap(int[] height) {
		int left = 0;
		int rigth = height.length - 1;
		int sum = 0;
		int h = Math.max(height[rigth], height[left]);
		int lh = 0;
		int rh = 0;
		while (left < rigth) {
			if (height[rigth] < h) {
				rh = Math.max(rh, height[rigth]);
				rigth--;
				if (height[rigth] < rh) {
					sum += rh - height[rigth];
				}
			} else if (height[left] <= h) {
				lh = Math.max(lh, height[left]);
				left++;
				if (height[left] < lh) {
					sum += lh - height[left];
				}
			}
			h = Math.max(height[rigth], height[left]);
		}
		return sum;
	}
}
