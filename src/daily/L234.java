package daily;

public class L234 {
	public static void main(String[] args) {
		new L234();
	}

	L234() {
	}

	private int iMax = 0;
	private int jMax = 0;

	public int numIslands(char[][] grid) {
		iMax = grid.length;
		jMax = grid[0].length;
		int ans = 0;
		for (int i = 0; i < iMax; i++) {
			for (int j = 0; j < jMax; j++) {
				if (grid[i][j] == '1') {
					ans++;
					visit(grid, i, j);
				}
			}
		}
		return ans;
	}

	public void visit(char[][] grid, int i, int j) {

		if (i < 0 || i >= iMax) {
			return;
		}

		if (j < 0 || j >= jMax) {
			return;
		}

		if (grid[i][j] == '0') {
			return;
		}

		grid[i][j] = '0';
		visit(grid, i + 1, j);
		visit(grid, i - 1, j);
		visit(grid, i, j + 1);
		visit(grid, i, j - 1);
	}
}
