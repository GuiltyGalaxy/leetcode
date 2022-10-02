package wc313;

public class L6193 {
	public static void main(String[] args) {
		new L6193();
	}

	L6193() {
	}

	public int maxSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int max = 0;
		for (int i = 0; i <= m - 3; i++) {
			for (int j = 0; j <= n - 3; j++) {
				max = Math.max(getSum(i, j, grid), max);
			}
		}
		return max;
	}

	public int getSum(int i, int j, int[][] grid) {
		int sum = 0;
		sum += grid[i][j];
		sum += grid[i][j + 1];
		sum += grid[i][j + 2];
		sum += grid[i + 1][j + 1];
		sum += grid[i + 2][j];
		sum += grid[i + 2][j + 1];
		sum += grid[i + 2][j + 2];
		return sum;
	}
}
