package contest.wc405.L3211;


import java.util.ArrayList;
import java.util.List;

class Solution {

    List<String> ans = new ArrayList<>();
    int len = 0;

    public List<String> validStrings(int n) {
        len = n;
        helper("1");
        helper("0");
        return ans;
    }

    private void helper(String s) {

        // 當長度符合則加入答案中
        // len=1為例外
        if (s.length() == len || len == 1) {
            ans.add(s);
            return;
        }

        // 由於2長之內要有一個1，如果前一個為1的時候，後面可以接上0 1
        // 反之為0時，後面一定要是1
        if (s.charAt(s.length() - 1) == '1') {
            helper(s + "1");
            helper(s + "0");
        } else {
            helper(s + "1");
        }
    }
}