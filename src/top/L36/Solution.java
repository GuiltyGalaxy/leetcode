package top.L36;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        //row
        for (int i = 0; i < board.length; i++) {
            if (checkLine(board[i])) {
                return false;
            }
        }
        //col
        for (int i = 0; i < board[0].length; i++) {
            char[] line = new char[9];
            for (int j = 0; j < 9; j++) {
                line[j] = board[j][i];
            }
            if (checkLine(line)) {
                return false;
            }
        }
        //3*3 board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //只檢查每個3*3的起點
                if (i % 3 != 0 || j % 3 != 0) {
                    continue;
                }
                if (checkBoard(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 檢查line是否有重複
     * @return ture:重複
     */
    private boolean checkLine(char[] line) {
        char[] check = new char[9];
        for (char c : line) {
            if (c == '.') {
                continue;
            }
            if (check[c - '1'] == 0) {
                check[c - '1'] = 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 以x,y為起點檢查3*3範圍內是否有重複
     * @return ture:重複
     */
    private boolean checkBoard(char[][] board, int x, int y) {
        char[] check = new char[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[x + i][y + j];
                if (c == '.') {
                    continue;
                }
                if (check[c - '1'] == 0) {
                    check[c - '1'] = 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}