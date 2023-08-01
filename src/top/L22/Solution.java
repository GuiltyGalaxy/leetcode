package top.L22;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private final List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(new StringBuilder(), 0, 0, n);
        return res;
    }

    public void dfs(StringBuilder sb, int open, int close, int max) {

        //長度符合則加入答案中
        if (sb.length() == max * 2) {
            res.add(sb.toString());
            return;
        }

        if (open < max) {
            dfs(sb.append("("), open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1);
        }
        // close < open才可加入close去找
        // 這樣close才會有對應open
        if (close < open) {
            dfs(sb.append(")"), open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}