package top.L22;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private int maxPairs;
    private List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        maxPairs = n;
        dfs(new StringBuilder(), 0, 0);
        return res;
    }

    public void dfs(StringBuilder sb, int open, int close) {

        //長度符合則加入答案中
        if (sb.length() == maxPairs * 2) {
            res.add(sb.toString());
            return;
        }

        if (open < maxPairs) {
            dfs(sb.append("("), open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }
        // close < open才可加入close去找
        // 這樣close才會有對應open
        if (close < open) {
            dfs(sb.append(")"), open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}