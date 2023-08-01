package top.L17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    private final List<String> res = new ArrayList<>();
    private final HashMap<Character, String> keyMap = new HashMap<>();

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return res;
        }

        // 初始化按鈕
        keyMap.put('2', "abc");
        keyMap.put('3', "def");
        keyMap.put('4', "ghi");
        keyMap.put('5', "jkl");
        keyMap.put('6', "mno");
        keyMap.put('7', "pqrs");
        keyMap.put('8', "tuv");
        keyMap.put('9', "wxyz");

        backtrack(digits, 0, new StringBuilder());
        return res;

    }

    private void backtrack(String digits, int i, StringBuilder sb) {

        // 長度一樣為一種可能加至答案中
        if (i == digits.length()) {
            res.add(sb.toString());
            return;
        }

        // 取得當前按鈕對應字母
        String curr = keyMap.get(digits.charAt(i));
        // 把每個字母都跑過
        for (int k = 0; k < curr.length(); k++) {
            sb.append(curr.charAt(k));
            backtrack(digits, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}