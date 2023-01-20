package top.L844;


class Solution {
    public boolean backspaceCompare(String s, String t) {

        int idx_s = s.length() - 1;
        int idx_t = t.length() - 1;
        int skip;

        while (true) {
            //處理s的#
            skip = 0;
            while (idx_s >= 0 && (skip > 0 || s.charAt(idx_s) == '#')) {
                skip += s.charAt(idx_s) == '#' ? 1 : -1;
                idx_s--;
            }
            //處理t的#
            skip = 0;
            while (idx_t >= 0 && (skip > 0 || t.charAt(idx_t) == '#')) {
                skip += t.charAt(idx_t) == '#' ? 1 : -1;
                idx_t--;
            }
            //比較當前的char要為一樣，繼續往後比
            if (idx_s >= 0 && idx_t >= 0 && s.charAt(idx_s) == t.charAt(idx_t)) {
                idx_s--;
                idx_t--;
            } else {
                break;
            }
        }
        //兩邊都比到結尾代表全部相等
        return idx_s == -1 && idx_t == -1;
    }
}