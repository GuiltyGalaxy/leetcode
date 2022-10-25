package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L1239 {

    L1239() {
        maxLength(List.of(new String[]{"un", "iq", "ue"}));
    }

    public static void main(String[] args) {
        new L1239();
    }

    public int maxLength(List<String> arr) {
        //dp存放所有不衝突的字串
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        int ans = 0;
        for (String s : arr) {
            //將26個英文字母假設成26個bit
            int a = 0;
            int dup = 0;
            for (char c : s.toCharArray()) {
                //如果現行 [a] & [字母bit] 為1
                //則代表有重複值
                dup |= a & (1 << (c - 'a'));
                a |= 1 << (c - 'a');
            }
            //重複不計算
            if (dup > 0) {
                continue;
            }
            //比對目前dp內的值
            for (int i = dp.size() - 1; i >= 0; i--) {
                //如果dp中有與現行a衝突
                //就不再放入了
                if ((dp.get(i) & a) > 0) {
                    continue;
                }
                //更新dp
                dp.add(dp.get(i) | a);
                //bit數就會等同於自串長度
                //因每個字只會出現一次
                //更新當前最大長度
                ans = Math.max(ans, Integer.bitCount(dp.get(i) | a));
            }
        }
        return ans;
    }
}
