package top.L242;

class Solution {
    public boolean isAnagram(String s, String t) {

        int[] a = new int[256];
        int[] b = new int[256];

        for (char c : s.toCharArray()) {
            a[c]++;
        }

        for (char c : t.toCharArray()) {
            b[c]++;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}