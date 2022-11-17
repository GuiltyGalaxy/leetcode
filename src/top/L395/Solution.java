package top.L395;

class Solution {

    public int longestSubstring(String s, int k) {
        return helper(s.toCharArray(), 0, s.length(), k);
    }


    private int helper(char[] c, int s, int e, int k) {

        if (e - s < k) {
            return 0;
        }
        //統計字數
        int[] count = new int[26];
        for (int i = s; i < e; i++) {
            count[c[i] - 'a']++;
        }

        for (int i = s; i < e; i++) {
            //尋找字數不符合k的斷點
            if (count[c[i] - 'a'] < k) {
                int j = i + 1;
                //找斷點尾
                while (j < e && count[c[j] - 'a'] < k) {
                    j++;
                }
                //從該斷點部分分割兩邊繼續找
                // aaabbbccdddeee k=3
                //這樣斷點會出現在cc上面
                //最大符合字串中一定不能出現小於k的字
                //由此可去利用不符合的節點去做切割(因一定不包含在答案中)
                //分成aaabbb,dddeee再繼續找下去
                return Math.max(helper(c, s, i, k), helper(c, j, e, k));
            }
        }
        return e - s;
    }
}