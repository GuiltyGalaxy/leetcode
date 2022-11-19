package top.L17;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final String[] MAP =
            {
                    "",
                    "",
                    "abc",
                    "def",
                    "ghi",
                    "jkl",
                    "mno",
                    "pqrs",
                    "tuv",
                    "wxyz"
            };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.equals("")) {
            return ans;
        }
        ans.add("");
        for (char c : digits.toCharArray()) {
            String key = MAP[c - '0'];
            List<String> tmp = new ArrayList<>();
            for (String s : ans) {
                for (char add : key.toCharArray()) {
                    tmp.add(s + add);
                }
            }
            ans = new ArrayList<>(tmp);
        }
        return ans;
    }
}