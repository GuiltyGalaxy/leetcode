package top.L200;

class Solution {

    private int N;
    private int M;

    public int numIslands(char[][] grid) {
        int ans = 0;
        N = grid.length;
        M = grid[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    setFlag(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void setFlag(char[][] grid, int row, int col) {

        if (row < 0 || row >= N) {
            return;
        }

        if (col < 0 || col >= M) {
            return;
        }

        if (grid[row][col] != '1') {
            return;
        }

        grid[row][col] = '0';

        setFlag(grid, row + 1, col);
        setFlag(grid, row - 1, col);
        setFlag(grid, row, col + 1);
        setFlag(grid, row, col - 1);

    }
}