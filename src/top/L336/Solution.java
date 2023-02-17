package top.L336;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {

        //1- null + palindrome, palindrome + null
        //2- s1 + s1.reverse
        //3- [s1,s2] + s1.reverse, s2 is palindrome
        //4- s2.reverse + [s1,s2], s1 is palindrome

        //optimize:
        //1- dp & cache for isPalindrome
        //2- Trie for find if reverse exist

        List<List<Integer>> res = new ArrayList<>();

        //store all words in dict
        HashMap<String, Integer> map = new HashMap<>();
        boolean[] dict = new boolean[5001];
        int cnt = 0;
        for (String word : words) {
            map.put(word, cnt);
            cnt++;
            dict[word.length()] = true;
        }

        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            if (word.length() == 0) {
                continue;
            }

            char[] ch = word.toCharArray();

            String re = new StringBuilder(word).reverse().toString();

            //3- [s1,s2] + s1.reverse
            for (int j = 0; j < ch.length - 1; j++) {
                if (dict[j + 1] && isPalindrome(ch, j + 1, ch.length - 1)) {
                    String check = re.substring(ch.length - j - 1, ch.length);

                    if (map.containsKey(check)) {
                        res.add(Arrays.asList(i, map.get(check)));
                    }
                }
            }

            //4- s2.reverse + [s1,s2]
            for (int j = 0; j < ch.length - 1; j++) {

                if (dict[ch.length - j - 1] && isPalindrome(ch, 0, j)) {
                    String check = re.substring(0, ch.length - j - 1);

                    if (map.containsKey(check)) {
                        res.add(Arrays.asList(map.get(check), i));
                    }
                }
            }

            //1- null + palindrome, palindrom + null
            //2- s1 + s1.reverse
            if (isPalindrome(ch, 0, ch.length - 1)) {
                if (map.containsKey("")) {
                    int index = map.get("");
                    res.add(Arrays.asList(index, i));
                    res.add(Arrays.asList(i, index));
                }
            } else if (map.containsKey(re)) {
                res.add(Arrays.asList(i, map.get(re)));
            }
        }

        return res;
    }

    //[left, right]
    // can be improved by dynamic programming, but need extra space to store the answer of subproblem
    private boolean isPalindrome(char[] ch, int left, int right) {
        while (left < right) {
            if (ch[left] != ch[right])
                return false;
            left++;
            right--;
        }
        return true;
    }
}