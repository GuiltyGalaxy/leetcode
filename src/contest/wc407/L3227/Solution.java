package contest.wc407.L3227;


class Solution {
    public boolean doesAliceWin(String s) {
        // 計算母音總數，由於Alice他可以移除基數個母音
        // 所以基本上要全部沒母音的字串Bob才能贏
        for (int i = 0; i < s.length(); ++i) {
            switch (s.charAt(i)) {
                case 'a':
                case 'i':
                case 'u':
                case 'e':
                case 'o':
                    return true;
            }
        }

        return false;
    }
}