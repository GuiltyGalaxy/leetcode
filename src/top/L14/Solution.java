package top.L14;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 由於取全部字串的最小相同前綴，所以取哪個先當基準都沒差
        // 假設第一個為解答
        String ans = strs[0];
        int len = ans.length();
        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            // 只要與當前s不符合則減去最後一個字
            // 或當前長度大於目前的s
            while (len > s.length() || !ans.equals(s.substring(0, len))) {
                len--;
                // 0代表沒有任何答案
                if (len == 0) {
                    return "";
                }
                ans = ans.substring(0, len);
            }
        }
        return ans;
    }
}