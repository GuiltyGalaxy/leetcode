package top.L336;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> ans = new ArrayList<>();

        // 將String[]轉換成map並記錄出現位子
        HashMap<String, Integer> map = new HashMap<>();
        // 紀錄是否有對應長度的字，題目範圍長度只出到0-5000
        boolean[] hasLength = new boolean[5001];
        int index = 0;
        for (String word : words) {
            map.put(word, index);
            index++;
            hasLength[word.length()] = true;
        }

        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            if (word.isEmpty()) {
                continue;
            }

            char[] cs = word.toCharArray();
            int csLen = cs.length;

            String re = new StringBuilder(word).reverse().toString();

            // 情況1:
            // 當s1[j:len]以符合Palindrome，這時候只要去找對應的s1.reverse[len-j:len]補齊即可
            // s1 = zxcvbccd
            // s1.reverse = dccbvcxz.
            // 由於bccd已達成Palindrome，所以不管前面有哪些字母，只要找到對應的Palindrome即可
            // 也就是 zxcvbccd + vcxz
            for (int j = 0; j < csLen - 1; j++) {
                if (hasLength[j + 1] && isPalindrome(cs, j + 1, csLen - 1)) {
                    String check = re.substring(csLen - j - 1, csLen);
                    if (map.containsKey(check)) {
                        ans.add(Arrays.asList(i, map.get(check)));
                    }
                }
            }

            // 情況2:
            // 同理情況1，只是找的對象反過來，原本是找後面字母Palindrome
            // 也就是s1[j:len]換成s1[0:j]去找前面字母Palindrome
            // s1 = bccdzxcv
            // s1.reverse = vcxzdccb
            // 也就是 bccd + vcxzdccb
            for (int j = 0; j < csLen - 1; j++) {
                if (hasLength[csLen - j - 1] && isPalindrome(cs, 0, j)) {
                    String check = re.substring(0, csLen - j - 1);
                    if (map.containsKey(check)) {
                        ans.add(Arrays.asList(map.get(check), i));
                    }
                }
            }

            if (isPalindrome(cs, 0, csLen - 1)) {
                // 情況3:自己本身就可以達成Palindrome
                if (map.containsKey("")) {
                    int emptyIndex = map.get("");
                    // 正反都可以達成所以記得要加入2組
                    ans.add(Arrays.asList(emptyIndex, i));
                    ans.add(Arrays.asList(i, emptyIndex));
                }
            } else if (map.containsKey(re)) {
                // 情況4:有對應自己本身的reverse字串
                ans.add(Arrays.asList(i, map.get(re)));
            }
        }

        return ans;
    }

    private boolean isPalindrome(char[] ch, int left, int right) {
        while (left < right) {
            if (ch[left++] != ch[right--]) {
                return false;
            }
        }
        return true;
    }
}