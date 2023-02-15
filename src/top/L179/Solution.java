package top.L179;

import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {

        //全部轉換成String
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = nums[i] + "";
        }
        //最大的數字組合剛好會為lexicographically
        //不過"3" "30"這種狀況"30"會排前面，這樣會不符合
        //所以暫時組合字串
        //使用"330" "303"去比較
        Arrays.sort(strings, (a, b) -> {
            String t1 = a + b;
            String t2 = b + a;
            return t2.compareTo(t1);
        });

        //排除都為0的特殊狀況
        if (strings[0].charAt(0) == '0') {
            return "0";
        }

        //組合String
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();
    }
}