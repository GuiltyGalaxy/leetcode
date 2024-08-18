package top.L131;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<List<String>> ans;

    /**
     * 該解法使用Backtracking(回朔法)
     * 枚舉所有可能性
     * O(N*2^N)
     */
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        solve(new ArrayList<>(), s, 0);
        return ans;
    }

    private void solve(ArrayList<String> temp, String s, int start) {

        //代表找到最後了把temp放進答案中
        if (start == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                //先將該區間放進答案中
                temp.add(s.substring(start, i + 1));
                //以該index往後尋找是否有Palindrome字串
                solve(temp, s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}