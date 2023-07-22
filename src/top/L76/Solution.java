package top.L76;

class Solution {
    public String minWindow(String s, String t) {

        String minString = "";
        int minCount = Integer.MAX_VALUE;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        //紀錄當前window中char統計
        char[] sWindow = new char[256];
        char[] tWindow = new char[256];

        for (char c : tArray) {
            tWindow[c]++;
        }

        int count = 0;
        int L = 0;
        int R = 0;
        while (R < sArray.length) {

            char cur = sArray[R];
            //cur含在tWindow中，且當前sWindow還沒達上限
            if (tWindow[cur] >= 1 && sWindow[cur] < tWindow[cur]) {
                count++;
            }

            //將當前char累加至sWindow
            sWindow[cur]++;


            //該條件成立代表sWindow中有滿足tWindow條件的集合
            if (count == tArray.length) {
                if (tWindow[cur] >= 1 && (sWindow[cur] >= tWindow[cur])) {
                    //sWindow中包含多餘的tWindow char
                    //從start開始往後移除到sWindow內符合tWindow
                    while (sWindow[sArray[L]] > tWindow[sArray[L]]) {
                        sWindow[sArray[L]]--;
                        L++;
                    }
                }

                //當前長度
                int currentLen = R - L + 1;
                //更新最小值
                if (minCount > currentLen) {
                    minCount = currentLen;
                    minString = s.substring(L, L + minCount);
                }
            }
            R++;
        }

        return minString;
    }
}