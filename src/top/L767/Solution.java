package top.L767;

class Solution {
    public String reorganizeString(String s) {

        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }

        int max = 0;
        int letter = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }

        //最大值超過一半則無法交替排放，一定會出現相鄰
        if (max > (s.length() + 1) / 2) {
            return "";
        }

        char[] ans = new char[s.length()];
        int idx = 0;
        //先放置最多的字
        while (hash[letter] > 0) {
            ans[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }
        //後面依序補上
        // a _ a _ a _ _ _ _
        // a b a _ a _ b _ b
        // a b a c a _ b _ b
        // a b a c a d b d b
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                //even位子都補完了，改換odd
                if (idx >= ans.length) {
                    idx = 1;
                }
                ans[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        return String.valueOf(ans);
    }
}