package daily.L899;

import java.util.Arrays;

class Solution {
    public String orderlyQueue(String s, int k) {
        //k只要大於1就有足夠空間排出 lexicographically
        if (k > 1) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            return new String(cs);
        }
        //只有1的情況則巡過所有字串
        String res = s;
        for (int i = 1; i < s.length(); i++) {
            String tmp = s.substring(i) + s.substring(0, i);
            //只要移動後的結果符合 lexicographically 就更新
            if (res.compareTo(tmp) > 0) {
                res = tmp;
            }
        }
        return res;
    }
}