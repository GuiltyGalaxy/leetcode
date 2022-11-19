package top.L22;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(list, "", 0, 0, n);
        return list;
    }

    public void dfs(List<String> list, String str, int open, int close, int max) {

        //長度符合則加入答案中
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }

        if (open < max) {
            dfs(list, str + "(", open + 1, close, max);
        }
        //close < open才可加入close去找
        if (close < open) {
            dfs(list, str + ")", open, close + 1, max);
        }
    }
}