package top.L131;

import java.util.ArrayList;
import java.util.List;

class Solution {

    /**
     * 該解法使用Backtracking(回朔法)
     * 枚舉所有可能性
     * O(N*2^N)
     */
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(0, s, new ArrayList<>(), ans);
        return ans;
    }

    private void solve(int index, String s, ArrayList<String> temp, List<List<String>> ans) {

        //代表找到最後了把temp放進答案中
        if (index == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                //先將該區間放進答案中
                temp.add(s.substring(index, i + 1));
                //以該index往後尋找是否有Palindrome字串
                solve(i + 1, s, temp, ans);
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