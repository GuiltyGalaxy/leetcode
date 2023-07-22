package top.L567;

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // 初始化arr，統計s1的char數量
        int[] s1CharCntArr = new int[128];
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        for (char ch : s1Arr) {
            ++s1CharCntArr[ch];
        }

        int L = 0;
        int R = 0;
        int hitCnt = 0;
        int matchLen = Integer.MAX_VALUE;
        while (R < s2Arr.length) {

            char c = s2Arr[R];

            // 判斷該字是否存在於s1中
            if (--s1CharCntArr[c] >= 0) {
                hitCnt++;
            }

            // 當hitCnt完全等同於s1的長度時，代表該window內有s1所有char
            // 開始判斷該window最大matchLen
            while (hitCnt == s1Arr.length) {
                int windowLen = R - L + 1;
                matchLen = Math.min(matchLen, windowLen);
                // 拿出最左邊char
                char left = s2Arr[L];
                // 如果移除的char是s1中的，則更新hitCnt
                if (++s1CharCntArr[left] > 0) {
                    hitCnt--;
                }
                // window邊界L右移
                L++;
            }
            // window邊界R右移
            R++;
        }
        // 兩數相等代表有window完全符合s1集合
        return matchLen == s1Arr.length;
    }
}