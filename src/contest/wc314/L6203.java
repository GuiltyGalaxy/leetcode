package contest.wc314;

public class L6203 {
	public static void main(String[] args) {
		new L6203();
	}

	L6203() {
		numberOfPaths(new int[][] { { 5, 2, 4 }, { 3, 0, 5 }, { 0, 7, 2 } }, 3);
	}

	private static final long MOD = (long) 1e9 + 7;

	public int numberOfPaths(int[][] grid, int k) {

		// 解題概念
		// 這題用傳統DFS會TLE，需要用dp解
		// 假設 (a1+a2+a3+a4+a5) % 9 = 0
		// 可以改寫成 (a2+a3+a4+a5) % 9 = a1 % 9
		// 這樣我們可以假設一個dp[i][j][k]
		// 因為%k一定小於k
		// 且可以解釋dp為，所有路徑到[i,j]所有的k值累計
		// 這樣算到最後dp[i][j][0]的數量就是解答了(因k=0代表整除的數量)
		int m = grid.length;
		int n = grid[0].length;
		long[][][] dp = new long[m][n][k];
		int mod = grid[0][0] % k;
		dp[0][0][mod] = 1;

		// 先把邊際值算出
		for (int i = 1; i < m; i++) {
			mod = (mod + grid[i][0]) % k;
			dp[i][0][mod] = 1;
		}

		// 重置mod
		mod = grid[0][0] % k;
		for (int j = 1; j < n; j++) {
			mod = (mod + grid[0][j]) % k;
			dp[0][j][mod] = 1;
		}

		// 下面做的事畫成圖長這樣
		// o 代表剛剛算完的邊際值
		//
		// o o o o o o
		// o + + + + →
		// o + + + + →
		// o + + + + →
		// o ↓ ↓ ↓ ↓ X

		// 算完邊際直接從1開始
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				// 算x邊
				for (int p = 0; p < k; p++) {
					int sum = (p + grid[i][j]) % k;
					dp[i][j][sum] = (dp[i][j][sum] + dp[i - 1][j][p]) % MOD;
				}
				// 算y邊
				for (int p = 0; p < k; p++) {
					int sum = (p + grid[i][j]) % k;
					dp[i][j][sum] = (dp[i][j][sum] + dp[i][j - 1][p]) % MOD;
				}
			}
		}

		// 把最後mod==0的結果回傳
		return (int) dp[m - 1][n - 1][0];
	}

}
