package daily.L1657;

import java.util.Arrays;

class Solution {

    public boolean closeStrings(String word1, String word2) {

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        //長度不同不可能替換成一樣
        if (word1.length() != word2.length()) {
            return false;
        }

        //統計字母數
        for (int i = 0; i < word1.length(); i++) {
            arr1[word1.charAt(i) - 'a']++;
            arr2[word2.charAt(i) - 'a']++;
        }


        //因題目有兩種方式
        //1:調換任意2字母位子，這代表字母順序不是重點
        //2:將字母全部替換，這代表字母只要有出現過都可替換成某個字

        //如果出現另一字串都沒出現的字，則沒有替換方法
        for (int i = 0; i < 26; i++) {
            if (arr1[i] > 0 && arr2[i] == 0) {
                return false;
            }
            if (arr1[i] == 0 && arr2[i] > 0) {
                return false;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}