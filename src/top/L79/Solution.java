package top.L79;

class Solution {

    private static int M = 0;
    private static int N = 0;

    public boolean exist(char[][] board, String word) {
        M = board.length;
        N = board[0].length;
        char[] cs = word.toCharArray();
        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (search(board, cs, 0, x, y)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 由x,y開始DSF搜尋
     */
    private boolean search(char[][] board, char[] w, int idx, int x, int y) {

        //找到目標路徑
        if (w.length == idx) {
            return true;
        }

        //邊緣檢測
        if (x < 0 || x >= N) {
            return false;
        }

        if (y < 0 || y >= M) {
            return false;
        }

        //不相符就直接跳出
        if (board[y][x] != w[idx]) {
            return false;
        }

        //標記已搜尋過
        char tmp = board[y][x];
        board[y][x] = '*';

        //往4個方向繼續找
        idx++;
        boolean ans = search(board, w, idx, x - 1, y) ||
                search(board, w, idx, x + 1, y) ||
                search(board, w, idx, x, y + 1) ||
                search(board, w, idx, x, y - 1);

        //復原標記
        board[y][x] = tmp;

        return ans;
    }
}