package contest.wc407.L3228;


class Solution {
    public int maxOperations(String s) {
        int zoerCnt = 0;
        int ans = 0;
        // 用來記錄目前的0是不是連續
        // 初始要看最後一個是不是0
        boolean isZoer = s.charAt(s.length() - 1) != '0';
        // 如何使用最多步數將所有的1移道最後
        // 假設11000就代表要移動2次才可變成00011
        // 1010則為 1 + 2 = 3次
        // 由上例可得知只要兩個1中間有0
        // 則後面1移動次數全部較加上中間出現過連續的0次數
        // 比如 100100100 則開頭的一經歷過3次連續的0
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '0' && !isZoer) {
                zoerCnt++;
                isZoer = true;
            } else if (c == '1') {
                ans += zoerCnt;
                isZoer = false;
            }
        }
        return ans;
    }
}