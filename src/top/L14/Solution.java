package top.L14;

class Solution {
    public String longestCommonPrefix(String[] strs) {

        String minWord = strs[0];
        //找出長度最小的字串
        for (String s : strs) {
            if (s.length() < minWord.length()) {
                minWord = s;
            }
        }

        if (minWord.length() == 0) return "";

        while (minWord.length() != 0) {
            int counter = 0;
            //尋找符合的目標數
            for (String s : strs) {
                if (s.startsWith(minWord)) {
                    counter++;
                }
            }
            if (counter == strs.length) {
                //符合array所有string
                return minWord;
            } else {
                //移除最後一個字
                minWord = minWord.substring(0, minWord.length() - 1);
            }
        }

        return minWord;
    }
}