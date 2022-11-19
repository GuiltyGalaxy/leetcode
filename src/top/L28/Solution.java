package top.L28;

class Solution {
    public int strStr(String haystack, String needle) {
        char[] cs = haystack.toCharArray();
        char[] ts = needle.toCharArray();
        int i = 0;
        for (; i < cs.length - ts.length + 1; i++) {
            for (int j = 0; j < ts.length; j++) {
                if (cs[i + j] != ts[j]) {
                    break;
                }
                if (j == ts.length - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}