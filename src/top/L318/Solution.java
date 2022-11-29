package top.L318;

class Solution {
    public int maxProduct(String[] words) {

        int len = words.length;
        //紀錄字母出現情況
        int[] word_map = new int[len];

        //建立word字母出現情況
        for (int i = 0; i < len; i++) {
            String tmp = words[i];
            word_map[i] = 0;
            for (int j = 0; j < tmp.length(); j++) {
                //將出現的字母bit => 1
                word_map[i] |= 1 << (tmp.charAt(j) - 'a');
            }
        }

        int ans = 0;
        //尋遍所有可能O(N^2)
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                boolean isDifferent = (word_map[i] & word_map[j]) == 0;
                boolean isLager = words[i].length() * words[j].length() > ans;
                if (isDifferent && isLager) {
                    ans = words[i].length() * words[j].length();
                }
            }
        }

        return ans;
    }
}