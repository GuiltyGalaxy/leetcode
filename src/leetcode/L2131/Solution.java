package leetcode.L2131;

class Solution {
    public int longestPalindrome(String[] words) {
        //words條件剛好為2長
        //不使用MAP，使用array取代
        int[][] counter = new int[26][26];
        int ans = 0;
        for (String w: words) {
            int a = w.charAt(0) - 'a';
            int b = w.charAt(1) - 'a';
            if (counter[b][a] > 0) {
                ans += 4;
                counter[b][a]--;
            } else {
                counter[a][b]++;
            }
        }
        //檢查是否有剩餘疊字可擺中間
        for (int i = 0; i < 26; i++) {
            if (counter[i][i] > 0) {
                ans += 2;
                break;
            }
        }
        return ans;
    }
}