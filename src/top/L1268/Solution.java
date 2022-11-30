package top.L1268;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        //先照lexicographically排序
        Arrays.sort(products);
        List<List<String>> results = new ArrayList<>();
        int L = 0;
        int R = products.length - 1;
        //Binary search
        for (int i = 0; i < searchWord.length(); i++) {
            char cur = searchWord.charAt(i);
            //左右逼近找符合的字
            //products[l].length() <= i的話直接跳過，不然products[l].charAt(i)會out of range
            while (L <= R && (products[L].length() <= i || products[L].charAt(i) != cur)) {
                L++;
            }
            while (L <= R && (products[L].length() <= i || products[R].charAt(i) != cur)) {
                R--;
            }
            //從l開始選3個字，到r結束
            List<String> result = new ArrayList<>();
            for (int j = L; j <= R; j++) {
                result.add(products[j]);
                if (result.size() == 3) {
                    break;
                }
            }
            results.add(result);
        }
        return results;
    }
}