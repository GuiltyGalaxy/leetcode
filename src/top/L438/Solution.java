package top.L438;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        char[] sA = s.toCharArray();
        char[] sP = p.toCharArray();
        int sLen = s.length();
        int pLen = p.length();

        // p比s長的話不可能有答案
        if (pLen > sLen) {
            return ans;
        }
        // 計算char數
        int[] sMap = new int[26];
        int[] pMap = new int[26];
        // 以p的長度當起始window
        for (int i = 0; i < pLen; i++) {
            sMap[sA[i] - 'a']++;
            pMap[sP[i] - 'a']++;
        }

        for (int i = 0; i <= sLen - pLen; i++) {
            if (isMapping(sMap, pMap)) {
                ans.add(i);
            }
            // window向後移動
            // 把頭元素去掉
            sMap[sA[i] - 'a']--;
            // 尚未超出sLen邊界的情況下，尾端新增元素
            if (i + pLen < sLen) {
                sMap[sA[i + pLen] - 'a']++;
            }
        }
        return ans;
    }

    private boolean isMapping(int[] arrs, int[] arrp) {
        for (int j = 0; j < 26; j++) {
            if (arrs[j] != arrp[j]) {
                return false;
            }
        }
        return true;
    }
}