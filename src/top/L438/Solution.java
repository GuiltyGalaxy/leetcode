package top.L438;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if (pLen > sLen) {
            return ans;
        }
        //計算char數
        //並且是以p的長度當window
        int[] sMap = new int[26];
        int[] pMap = new int[26];
        for (int i = 0; i < pLen; i++) {
            sMap[s.charAt(i) - 'a']++;
            pMap[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= sLen - pLen; i++) {
            if (isMapping(sMap, pMap)) {
                ans.add(i);
            }
            //整體後移
            sMap[s.charAt(i) - 'a']--;
            if (i + pLen < sLen) {
                //長度夠的情況下要連同後面一起加
                sMap[s.charAt(i + pLen) - 'a']++;
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