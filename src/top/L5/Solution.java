package top.L5;

public class Solution {

    private final int LEFT = -1;
    private final int MID = 0;
    private final int RIGHT = 1;
    private int begin, maxLen;

    public String longestPalindrome(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        // 從中間開始找
        expandCenter(str, n / 2, MID);
        return new String(str, begin, maxLen);
    }

    private void expandCenter(char[] str, int idx, int direction) {
        int len = str.length;
        int i = idx - 1;
        int j = idx + 1;

        // 撇除掉起始相同的字
        // 這動作是為了避免偶數的情況 "abba"
        // ex. "naaaaaan"
        //      ^   ^  ^
        //      |   |  |
        //      i  idx j
        while (i >= 0 && str[i] == str[idx]) i--;
        while (j < len && str[j] == str[idx]) j++;

        // 計算最大回文長度
        int left = i;
        int right = j;
        while (left >= 0 && right < len && str[left] == str[right]) {
            left--;
            right++;
        }

        // 如果比當前最大回文大則記錄
        if (right - left - 1 > maxLen) {
            begin = left + 1;
            maxLen = right - left - 1;
        }

        // 剩下的長度如果比目前maxLen大
        // 代表還有更長的可能，所以繼續找
        if (((i + 1) * 2) > maxLen && direction <= MID) {
            expandCenter(str, i, LEFT);
        }

        if (((len - j) * 2) > maxLen && direction >= MID) {
            expandCenter(str, j, RIGHT);
        }
    }

}
