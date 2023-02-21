package top.L733;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //顏色相同就直接不處理
        if (image[sr][sc] == color) {
            return image;
        }
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int newColor) {

        if (sr < 0 || sr >= image.length) {
            return;
        }

        if (sc < 0 || sc >= image[0].length) {
            return;
        }
        //與先前顏色相同才可異動
        if (image[sr][sc] != color) {
            return;
        }
        //往4個方向繼續塗
        image[sr][sc] = newColor;
        dfs(image, sr - 1, sc, color, newColor);
        dfs(image, sr + 1, sc, color, newColor);
        dfs(image, sr, sc - 1, color, newColor);
        dfs(image, sr, sc + 1, color, newColor);
    }
}