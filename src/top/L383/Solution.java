package top.L383;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[26];

        // 紀錄可用字母
        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }

        // 依照ransomNote去使用現有字母
        for (char c : ransomNote.toCharArray()) {
            charCount[c - 'a']--;
            if (charCount[c - 'a'] < 0) {
                // 現有字母不足
                return false;
            }
        }

        return true;
    }
}