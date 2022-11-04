package leetcode.L345;

class Solution {
    public String reverseVowels(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] cs = s.toCharArray();

        while (start < end) {
            //往右找目標
            while (start < s.length() && !isVowel(cs[start])) {
                start++;
            }
            //往左找目標
            while (end >= 0 && !isVowel(cs[end])) {
                end--;
            }
            //互換該位子
            if (start < end) {
                swap(cs, start++, end--);
            }
        }
        return new String(cs);
    }

    void swap(char[] cs, int x, int y) {
        char temp = cs[x];
        cs[x] = cs[y];
        cs[y] = temp;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u'
                || c == 'A' || c == 'I' || c == 'E' || c == 'O' || c == 'U';
    }
}