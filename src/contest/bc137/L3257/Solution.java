package contest.bc137.L3257;


import java.util.*;

class Solution {

    public long max = Long.MIN_VALUE;

    /**
     * 題目與3256一樣，複雜度提升
     */
    public long maximumValueSum(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        List<List<Integer>> valuesList = new ArrayList<>(m * n);
        // 取出每個row中的前三大數值
        for (int i = 0; i < m; i++) {
            List<List<Integer>> rowValues = new ArrayList<>(n);
            int max1 = -1;
            int max2 = -1;
            int max3 = -1;
            for (int j = 0; j < n; j++) {
                rowValues.add(new ArrayList<>(3));
                List<Integer> value = rowValues.get(rowValues.size() - 1);
                value.add(board[i][j]);
                value.add(i);
                value.add(j);
                if (max1 == -1 || board[i][j] >= rowValues.get(max1).get(0)) {
                    max3 = max2;
                    max2 = max1;
                    max1 = j;
                } else if (max2 == -1 || board[i][j] >= rowValues.get(max2).get(0)) {
                    max3 = max2;
                    max2 = j;
                } else if (max3 == -1 || board[i][j] >= rowValues.get(max3).get(0)) {
                    max3 = j;
                }
            }
            valuesList.add(rowValues.get(max1));
            valuesList.add(rowValues.get(max2));
            valuesList.add(rowValues.get(max3));
        }
        valuesList.sort((a, b) -> b.get(0) - a.get(0));
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        backtrack(0, 0, 0, valuesList, rows, cols);

        return max;
    }

    public void backtrack(int idx, long curSum, int nums, List<List<Integer>> valuesList, boolean[] rows, boolean[] cols) {
        if (nums == 3) {
            max = Math.max(curSum,max);
            return;
        }

        if (idx >= valuesList.size()) {
            return;
        }

        long value = valuesList.get(idx).get(0);

        // 該數值加上後沒比max大提前返回
        if (curSum + value * (3 - nums) < max) {
            return;
        }

        // backtrack把每個可能選一遍
        int row = valuesList.get(idx).get(1);
        int col = valuesList.get(idx).get(2);
        if (!rows[row] && !cols[col]) {
            rows[row] = true;
            cols[col] = true;
            backtrack(idx + 1, curSum + value, nums + 1, valuesList, rows, cols);
            rows[row] = false;
            cols[col] = false;
        }

        // 也可以不選
        backtrack(idx + 1, curSum, nums, valuesList, rows, cols);

    }
}